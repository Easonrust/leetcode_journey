import java.util.Arrays;

/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (51.75%)
 * Likes:    1911
 * Dislikes: 283
 * Total Accepted:    146.3K
 * Total Submissions: 282.2K
 * Testcase Example:  '2'
 *
 * Given an integer n, break it into the sum of k positive integers, where k >=
 * 2, and maximize the product of those integers.
 * 
 * Return the maximum product you can get.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= n <= 58
 * 
 * 
 */

// @lc code=start
class Solution {
 public int integerBreak(int n) {
  int[] dp = new int[n + 1];
  Arrays.fill(dp, 0);
  dp[1] = 1;
  for (int i = 2; i <= n; ++i) {
   for (int j = 1; j <= i - 1; ++j) {
    dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
   }
  }
  return dp[n];

 }
}
// @lc code=end
// 记牢这道题的状态转移公式
