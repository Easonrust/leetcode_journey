class Solution {
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean[][] visited;
    boolean res = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == word.charAt(0) && res == false) {
                    visited[i][j] = true;
                    dfs(word, board, 1, i, j);
                    visited[i][j] = false;
                }
            }
        }
        return res;
    }

    private void dfs(String word, char[][] board, int start, int i, int j) {
        if (start == word.length()) {
            res = true;
            return;
        }

        int m = board.length;
        int n = board[0].length;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                if (board[ni][nj] == word.charAt(start) && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    dfs(word, board, start + 1, ni, nj);
                    visited[ni][nj] = false;
                }
            }
        }
    }
}