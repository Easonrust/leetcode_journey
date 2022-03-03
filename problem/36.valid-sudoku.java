// @lc code=start
class Solution {
 public boolean isValidSudoku(char[][] board) {
     Set<Character>[] rows=new HashSet[9];
     Set<Character>[] cols=new HashSet[9];
     Set<Character>[] boxes=new HashSet[9];
     
     
     for(int i=0;i<9;++i){
         rows[i]=new HashSet<>();
         cols[i]=new HashSet<>();
         boxes[i]=new HashSet<>();
     }
     
     for(int i=0;i<9;++i){
         for(int j=0;j<9;++j){
             if(Character.isDigit(board[i][j])){
                 if(rows[i].contains(board[i][j])){
                     return false;
                 }else{
                     rows[i].add(board[i][j]);
                 }
                 if(cols[j].contains(board[i][j])){
                     return false;
                 }else{
                     cols[j].add(board[i][j]);
                 }

                 if(boxes[i/3*3+j/3].contains(board[i][j])){
                     return false;
                 }else{
                     boxes[i/3*3+j/3].add(board[i][j]);
                 }
             }
         }
     }
     return true;
 }
}

// HashSet 在每一个格子处进行判断即可
// @lc code=end

