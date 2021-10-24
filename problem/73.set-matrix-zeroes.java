/*
 * @lc app=leetcode id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 */

// @lc code=start
class Solution {
 public void setZeroes(int[][] matrix) {
  int[][] marked = new int[matrix.length][matrix[0].length];
  for (int i = 0; i < matrix.length; ++i) {
   for (int j = 0; j < matrix[0].length; ++j) {
    if (matrix[i][j] == 0) {
     for (int j1 = 0; j1 < matrix[0].length; ++j1) {
      marked[i][j1] = 2;
     }
     for (int i1 = 0; i1 < matrix.length; ++i1) {
      marked[i1][j] = 2;
     }
    }
   }
  }

  for (int i = 0; i < matrix.length; ++i) {
   for (int j = 0; j < matrix[0].length; ++j) {
    if (marked[i][j] == 2) {
     matrix[i][j] = 0;
    }
   }
  }
 }
}

// 定义一个二维的mark矩阵解决问题
// @lc code=end
