class Solution {
    boolean find;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(word.charAt(0)==board[i][j]){
                    visited[i][j] = true;
                    dfs(board, word, i, j, 1);
                    visited[i][j] = false;
                }
                if(find){
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int i, int j, int start) {
        if(start==word.length()){
            find = true;
            return;
        }

        int m = board.length;
        int n = board[0].length;

        int[][] dirs = new int[][] {{-1,0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] dir:dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni>=0&&ni<m&&nj>=0&&nj<n&&!visited[ni][nj]&&board[ni][nj]==word.charAt(start)){
                visited[ni][nj] = true;
                dfs(board, word, ni, nj, start+1);
                visited[ni][nj] = false;
            }
        }
    }
}