/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {

 int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

 public int longestIncreasingPath(int[][] matrix) {
  int[][] memo = new int[matrix.length][matrix[0].length];
  int res = 0;
  for (int i = 0; i < matrix.length; ++i) {
   for (int j = 0; j < matrix[0].length; ++j) {
    res = Math.max(res, dfs(matrix, i, j, memo));
   }
  }
  return res;
 }

 public int dfs(int[][] matrix, int i, int j, int[][] memo) {

  // 以这个格子为起点的最长路径已经计算过了，不要重复计算
  if (memo[i][j] != 0) {
   return memo[i][j];
  }

  int maxL = 0;

  for (int[] d : directions) {
   int ni = i + d[0];
   int nj = j + d[1];
   if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[ni][nj] > matrix[i][j]) {
    maxL = Math.max(maxL, dfs(matrix, ni, nj, memo));
   }
  }

  memo[i][j] = maxL + 1;
  return memo[i][j];
 }
}

// 使用dfs，并且把所有中间结果用数组存储起来，避免重复计算
// @lc code=end
