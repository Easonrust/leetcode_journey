/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 *
 * https://leetcode.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (48.94%)
 * Likes:    3381
 * Dislikes: 116
 * Total Accepted:    262.5K
 * Total Submissions: 532.4K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * 
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3
 * sub-boxes of the grid.
 * 
 * 
 * The '.' character indicates empty cells.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output:
 * [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is
 * shown below:
 * 
 * 
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 * 
 * 
 */

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
