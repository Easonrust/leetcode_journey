/*
 * @lc app=leetcode id=188 lang=java
 *
 * [188] Best Time to Buy and Sell Stock IV
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 *
 * algorithms
 * Hard (31.03%)
 * Likes:    2831
 * Dislikes: 146
 * Total Accepted:    197.8K
 * Total Submissions: 633.4K
 * Testcase Example:  '2\n[2,4,1]'
 *
 * You are given an integer array prices where prices[i] is the price of a
 * given stock on the i^th day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit
 * = 4-2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit
 * = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3),
 * profit = 3-0 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= k <= 100
 * 0 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
 public int maxProfit(int k, int[] prices) {
  int n = prices.length;
  if (k >= n / 2) { // 这种情况下该问题退化为普通的股票交易问题
   int maxProfit = 0;
   for (int i = 1; i < n; i++) {
    if (prices[i] > prices[i - 1]) {
     maxProfit += prices[i] - prices[i - 1];
    }
   }
   return maxProfit;
  }
  int[][] maxProfit = new int[k + 1][n];
  for (int i = 1; i <= k; i++) {
   int localMax = maxProfit[i - 1][0] - prices[0];
   for (int j = 1; j < n; j++) {
    maxProfit[i][j] = Math.max(maxProfit[i][j - 1], prices[j] + localMax);
    localMax = Math.max(localMax, maxProfit[i - 1][j] - prices[j]);
   }
  }
  return maxProfit[k][n - 1];
 }
}
// @lc code=end
