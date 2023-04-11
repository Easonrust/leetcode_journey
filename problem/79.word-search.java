class Solution {
    boolean[][] visited;
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                char cur = board[i][j];
                if(cur==word.charAt(0)){
                    visited[i][j] = true;
                    dfs(board, word, i, j, 1);
                    visited[i][j] = false;
                }
                if(find==true){
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] board, String word, int x, int y, int len) {
        if(len==word.length()){
            find = true;
        }
        if(find==true){
            return;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = board.length;
        int n = board[0].length;
        for(int[] dir:dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx<0||ny<0||nx>=m||ny>=n){
                continue;
            }
            if(visited[nx][ny]){
                continue;
            }
            if(board[nx][ny]!=word.charAt(len)){
                continue;
            }
            visited[nx][ny] = true;
            dfs(board, word, nx, ny, len+1);
            visited[nx][ny] = false;
        }
    }
}