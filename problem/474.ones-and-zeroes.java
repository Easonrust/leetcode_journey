/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 *
 * https://leetcode.com/problems/ones-and-zeroes/description/
 *
 * algorithms
 * Medium (43.60%)
 * Likes:    2182
 * Dislikes: 305
 * Total Accepted:    90.4K
 * Total Submissions: 206.9K
 * Testcase Example:  '["10","0001","111001","1","0"]\n5\n3'
 *
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of
 * y.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the
 * maximum of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findMaxForm(String[] strs, int m, int n) {
  int[][] dp = new int[m + 1][n + 1];
  for (String s : strs) {
   int ones = 0, zeros = 0;
   for (char c : s.toCharArray()) {
    if (c == '0') {
     zeros++;
    } else {
     ones++;
    }
   }
   for (int i = m; i >= zeros; i--) {
    for (int j = n; j >= ones; j--) {
     dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
    }
   }
  }
  return dp[m][n];
 }
}
// @lc code=end
// 将其转换为多维度的0-1背包问题
