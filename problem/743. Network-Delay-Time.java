class Solution {
    class State {
        int id;
        int distFromStart;

        State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < graph.length; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from].add(new int[] { to, weight });
        }

        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[k] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> (o1.distFromStart - o2.distFromStart));
        pq.offer(new State(k, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curId = curState.id;
            int curDistFromStart = curState.distFromStart;
            if (curDistFromStart > distTo[curId]) {
                continue;
            }
            for (int[] neighbor : graph[curId]) {
                int nextDistance = curDistFromStart + neighbor[1];
                if (nextDistance < distTo[neighbor[0]]) {
                    distTo[neighbor[0]] = nextDistance;
                    pq.offer(new State(neighbor[0], nextDistance));
                }
            }
        }

        int res = 0;
        for (int i = 1; i < distTo.length; ++i) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, distTo[i]);
        }
        return res;
    }
}
