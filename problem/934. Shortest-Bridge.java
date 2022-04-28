class Solution {
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int shortestBridge(int[][] grid) {
        boolean flag = true;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && flag == true) {
                    dfs(grid, i, j);
                    flag = false;
                } else if (grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        int res = 0;
        return bfs(grid);
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == -1 || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = -1;
        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }

    private int bfs(int[][] grid) {

        int step = 0;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int ni = 0; ni < s; ++ni) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == -1) {
                    return step - 1;
                }
                grid[x][y] = 1;
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 1) {
                        continue;
                    }
                    queue.offer(new int[] { nx, ny });
                }
            }
            step++;
        }
        return step - 1;
    }
}

// TLE
