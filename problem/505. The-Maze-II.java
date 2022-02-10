class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    int step = 0;
                    while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
                        nx += dir[0];
                        ny += dir[1];
                        step++;
                    }
                    if (distance[nx - dir[0]][ny - dir[1]] > distance[cur[0]][cur[1]] + step) {
                        distance[nx - dir[0]][ny - dir[1]] = distance[cur[0]][cur[1]] + step;
                        queue.add(new int[] { nx - dir[0], ny - dir[1] });
                    }
                }
            }
        }

        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1
                : distance[destination[0]][destination[1]];
    }
}

// distance[i][j] 中存储到达i,j位置的步数，可能要计算很多可能性，所以不要用visited数组
