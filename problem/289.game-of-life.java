/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
 int[][] direction = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 } };

 public void gameOfLife(int[][] board) {
  int m = board.length;
  int n = board[0].length;

  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (board[i][j] == 0) {
     int count = countLive(board, i, j);
     if (count == 3) {
      board[i][j] = 2;
     }
    } else if (board[i][j] == 1) {
     int count = countLive(board, i, j);
     if (count < 2) {
      board[i][j] = 3;
     } else if (count > 3) {
      board[i][j] = 3;
     }
    }
   }
  }

  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (board[i][j] == 2) {
     board[i][j] = 1;
    }
    if (board[i][j] == 3) {
     board[i][j] = 0;
    }
   }
  }
 }

 public int countLive(int[][] board, int i, int j) {
  int count = 0;
  for (int[] d : direction) {
   int ni = i + d[0];
   int nj = j + d[1];
   if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
    if (board[ni][nj] == 1 || board[ni][nj] == 3) {
     count += 1;
    }
   }
  }

  return count;
 }
}

// 定义四种状态即可
// @lc code=end
