/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (48.20%)
 * Likes:    6387
 * Dislikes: 75
 * Total Accepted:    385.4K
 * Total Submissions: 795.6K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int minDistance(String word1, String word2) {
  int m = word1.length();
  int n = word2.length();
  int[][] dp = new int[m + 1][n + 1];
  for (int i = 0; i <= m; i++) {
   dp[i][0] = i;
  }
  for (int j = 0; j <= n; j++) {
   dp[0][j] = j;
  }
  for (int i = 1; i <= m; i++) {
   for (int j = 1; j <= n; j++) {
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
     dp[i][j] = dp[i - 1][j - 1];
    } else {
     dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
    }
   }
  }
  return dp[m][n];
 }
}
// @lc code=end
// 与题目583相比，这一题不求最长的公共子序列，而是直接求最小改变的step
// 注意初始化的问题
// 在相应位置不同的情况下，需要考虑减小1、减小2、replace三种情况取最小的那一个
