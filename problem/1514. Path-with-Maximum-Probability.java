class Solution {
    class State {
        int id;
        double probFromStart;

        State(int id, double probFromStart) {
            this.id = id;
            this.probFromStart = probFromStart;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; ++i) {
            graph[edges[i][0]].add(new double[] { (double) edges[i][1], succProb[i] });
            graph[edges[i][1]].add(new double[] { (double) edges[i][0], succProb[i] });
        }

        double[] probTo = new double[n];
        Arrays.fill(probTo, -1.0);
        probTo[start] = 1.0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.probFromStart, a.probFromStart);
        });
        pq.offer(new State(start, 1));
        while (!pq.isEmpty()) {
            State curState = pq.poll();
            double curProb = curState.probFromStart;
            if (curState.id == end) {
                return curProb;
            }

            if (curProb < probTo[curState.id]) {
                continue;
            }

            for (double[] neighbor : graph[curState.id]) {
                int nextId = (int) neighbor[0];
                double nextProb = neighbor[1] * curProb;
                if (nextProb > probTo[nextId]) {
                    probTo[nextId] = nextProb;
                    pq.offer(new State(nextId, nextProb));
                }
            }
        }

        return 0;
    }
}
