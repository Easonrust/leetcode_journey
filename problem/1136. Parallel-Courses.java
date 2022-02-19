class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegrees = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            indegrees[relation[1]]++;
            graph.get(relation[0]).add(relation[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        int step = 1;

        for (int i = 1; i <= n; ++i) {
            if (indegrees[i] == 0) {
                queue.offer(i);
                cnt++;
            }
        }

        if (cnt == n) {
            return step;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curCourse = queue.poll();
                for (int nextCourse : graph.get(curCourse)) {
                    indegrees[nextCourse]--;
                    if (indegrees[nextCourse] == 0) {
                        queue.offer(nextCourse);
                        cnt++;
                    }
                }
            }
            step++;
            if (cnt == n) {
                break;
            }
        }

        return cnt == n ? step : -1;
    }
}

// Kahn's Algorithm，每学期尽量上课（入度为0的都加入队列），使用BFS
