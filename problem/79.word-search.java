class Solution {
    boolean[][] visited;
    boolean find;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(word.charAt(0)==board[i][j]){
                    visited[i][j] = true;
                    dfs(board, i, j, 1, word);
                    visited[i][j] = false;
                }
                if(find==true){
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, int i, int j, int len, String word) {
        if(len==word.length()){
            find = true;
            return;
        }
        if(find==true){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int[] dir:dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni<0||nj<0||ni>=m||nj>=n){
                continue;
            }
            if(visited[ni][nj]){
                continue;
            }
            if(board[ni][nj]!=word.charAt(len)){
                continue;
            }
            visited[ni][nj] = true;
            dfs(board, ni, nj, len+1, word);
            visited[ni][nj] = false;
        }
    }
}