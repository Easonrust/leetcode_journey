/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
 public int maximalSquare(char[][] matrix) {
  int maxL = 0;
  int m = matrix.length;
  int n = matrix[0].length;
  int[][] dp = new int[m + 1][n + 1];
  for (int i = 1; i <= m; ++i) {
   for (int j = 1; j <= n; ++j) {
    if (matrix[i - 1][j - 1] == '1') {
     dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
     maxL = Math.max(maxL, dp[i][j]);
    }
   }
  }

  return maxL * maxL;

 }
}

// dp[i][j] 表示以matrix[i-1][j-1]为右下角的最大正方形的边长
// @lc code=end
