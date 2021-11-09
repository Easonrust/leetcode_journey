/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
 public int numTrees(int n) {
  int[] dp = new int[n + 1];

  // base case
  dp[0] = 1;
  dp[1] = 1;

  for (int i = 2; i <= n; ++i) {
   for (int j = 1; j <= i; ++j) {
    dp[i] += dp[j - 1] * dp[i - j];
   }
  }

  return dp[n];
 }
}

// dp
// dp[i] 表示使用i长度序列所能组成的子树的个数
// 遍历dp[i]在序列中的根，dp[i]就等于当前根下，左右子树的长度相加
// @lc code=end
