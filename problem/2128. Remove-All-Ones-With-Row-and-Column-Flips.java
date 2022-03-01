class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] flippedCol = new boolean[n];
        boolean[] flippedRow = new boolean[m];
        for (int j = 0; j < n; ++j) {
            if (grid[0][j] == 1) {
                flipCol(grid, j);
            }
            flippedCol[j] = true;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    if (flippedRow[i] == false) {
                        flipRow(grid, i);
                        flippedRow[i] = true;
                    } else {
                        return false;
                    }
                } else {
                    flippedRow[i] = true;
                }
            }
        }
        return true;
    }

    private void flipCol(int[][] grid, int col) {
        for (int i = 0; i < grid.length; ++i) {
            grid[i][col] = 1 - grid[i][col];
        }
    }

    private void flipRow(int[][] grid, int row) {
        for (int j = 0; j < grid[0].length; ++j) {
            grid[row][j] = 1 - grid[row][j];
        }
    }
}
