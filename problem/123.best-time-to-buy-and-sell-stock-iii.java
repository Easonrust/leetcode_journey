/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 *
 * algorithms
 * Hard (40.92%)
 * Likes:    4195
 * Dislikes: 94
 * Total Accepted:    312.6K
 * Total Submissions: 760.5K
 * Testcase Example:  '[3,3,5,0,0,3,1,4]'
 *
 * You are given an array prices where prices[i] is the price of a given stock
 * on the i^th day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit
 * = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 =
 * 3.
 * 
 * Example 2:
 * 
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit
 * = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
 * are engaging multiple transactions at the same time. You must sell before
 * buying again.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: prices = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= prices.length <= 10^5
 * 0 <= prices[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
 public int maxProfit(int[] prices) {
  int firstBuy = -prices[0];
  int firstSell = 0;
  int secondBuy = Integer.MIN_VALUE;
  int secondSell = 0;
  for (int price : prices) {
   firstBuy = Math.max(firstBuy, -price);
   firstSell = Math.max(firstSell, firstBuy + price);
   secondBuy = Math.max(secondBuy, firstSell - price);
   secondSell = Math.max(secondSell, secondBuy + price);
  }
  return secondSell;
 }
}
// @lc code=end
// 和背包问题相似，这里采用了空间优化，不用空间优化的解法可参考https://blog.csdn.net/lw_power/article/details/103773822?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0.control&spm=1001.2101.3001.4242
