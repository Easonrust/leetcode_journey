class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                char ch = board[i][j];
                if(ch!='.'){
                    int digit = ch - '0' - 1;
                    rows[i][digit]++;
                    cols[j][digit]++;
                    subboxes[i/3][j/3][digit]++;
                    if(rows[i][digit]>1||cols[j][digit]>1||subboxes[i/3][j/3][digit]>1){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}