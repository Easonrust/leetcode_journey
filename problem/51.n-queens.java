class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; ++i){
            Arrays.fill(board[i], '.');
        }
        backTracking(board, 0);
        return res;
    }
    
    private void backTracking(char[][] board, int row){
        if(row==board.length){
            res.add(getBoardList(board));
            return;
        }
        
        for(int col=0; col<board[0].length; ++col){
            if(!isValid(board, row, col)){
                continue;
            }
            
            board[row][col] = 'Q';
            backTracking(board, row+1);
            board[row][col] = '.';
        }
    }
    
    
    private List<String> getBoardList(char[][] board){
        List<String> boardList = new ArrayList<>();
        for(int i=0; i<board.length; ++i){
            boardList.add(new String(board[i]));
        }
        return boardList;
    }
    
    private boolean isValid(char[][] board, int row, int col){
        if(board[row][col]!='.'){
            return false;
        }
        
        for(int i=0; i<row; ++i){
            if(board[i][col]!='.'){
                return false;
            }
        }
        
        for(int i=row-1, j= col + 1; i>=0&&j<board[0].length; i--, j++){
            if(board[i][j]!='.'){
                return false;
            }
        }
        
        for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]!='.'){
                return false;
            }
        }
        
        return true;
    }
}