/*
 * @lc app=leetcode id=583 lang=java
 *
 * [583] Delete Operation for Two Strings
 *
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 *
 * algorithms
 * Medium (52.50%)
 * Likes:    2050
 * Dislikes: 38
 * Total Accepted:    89.7K
 * Total Submissions: 169.8K
 * Testcase Example:  '"sea"\n"eat"'
 *
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to
 * make "eat" to "ea".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int minDistance(String word1, String word2) {
  int m = word1.length();
  int n = word2.length();
  int[][] dp = new int[m + 1][n + 1];
  for (int i = 1; i <= m; ++i) {
   for (int j = 1; j <= n; ++j) {
    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
     dp[i][j] = dp[i - 1][j - 1] + 1;
    } else {
     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    }
   }
  }
  return m + n - 2 * dp[m][n];
 }
}
// @lc code=end
// 可转换成求两字符串的最长公共子序列的问题
