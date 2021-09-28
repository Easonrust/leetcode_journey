/*
 * @lc app=leetcode id=122 lang=java
 *
 * [122] Best Time to Buy and Sell Stock II
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 */

// @lc code=start
class Solution {
 public int maxProfit(int[] prices) {
  int max = 0;
  for (int i = 1; i < prices.length; ++i) {
   if (prices[i] > prices[i - 1]) {
    max += prices[i] - prices[i - 1];
   }
  }
  return max;
 }
}
// @lc code=end
// 注意跟121求最大的思想是不一样的
// 由于可以进行多次交易，因此只要比前一天的价格高，就计算在内即可
