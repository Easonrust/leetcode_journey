// @lc code=start
class Solution {
 public void solveSudoku(char[][] board) {
  boolean[][] rowUsed = new boolean[9][10];
  boolean[][] colUsed = new boolean[9][10];
  boolean[][] cubesUsed = new boolean[9][10];
  for (int i = 0; i < 9; ++i) {
   for (int j = 0; j < 9; ++j) {
    if (board[i][j] != '.') {
     int num = board[i][j] - '0';
     rowUsed[i][num] = true;
     colUsed[j][num] = true;
     cubesUsed[cubeNum(i, j)][num] = true;

    }
   }
  }
  backTracking(board, rowUsed, colUsed, cubesUsed, 0, 0);
  return;
 }

 private boolean backTracking(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][] cubesUsed, int row,
   int col) {
  while (row < 9 && board[row][col] != '.') {
   row = col == 8 ? row + 1 : row;
   col = col == 8 ? 0 : col + 1;
  }
  if (row == 9) {
   return true;
  }
  for (int i = 1; i <= 9; ++i) {
   if (rowUsed[row][i] || colUsed[col][i] || cubesUsed[cubeNum(row, col)][i]) {
    continue;
   }
   rowUsed[row][i] = colUsed[col][i] = cubesUsed[cubeNum(row, col)][i] = true;
   board[row][col] = (char) (i + '0');
   if (backTracking(board, rowUsed, colUsed, cubesUsed, row, col)) {
    return true;
   }
   board[row][col] = '.';
   rowUsed[row][i] = colUsed[col][i] = cubesUsed[cubeNum(row, col)][i] = false;
  }
  return false;
 }

 private int cubeNum(int i, int j) {
  int r = i / 3;
  int c = j / 3;
  return 3 * r + c;
 }
}
// @lc code=end
