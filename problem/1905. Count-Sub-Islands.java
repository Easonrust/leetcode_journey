class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(i, j, grid2);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 1) {
                    cnt++;
                    dfs(i, j, grid2);
                }
            }
        }

        return cnt;
    }

    private void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        for (int[] d : dirs) {
            dfs(i + d[0], j + d[1], grid);
        }
    }
}