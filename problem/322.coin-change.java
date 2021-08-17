/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 *
 * https://leetcode.com/problems/coin-change/description/
 *
 * algorithms
 * Medium (38.41%)
 * Likes:    7984
 * Dislikes: 220
 * Total Accepted:    720K
 * Total Submissions: 1.9M
 * Testcase Example:  '[1,2,5]\n11'
 *
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: coins = [2], amount = 3
 * Output: -1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: coins = [1], amount = 0
 * Output: 0
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: coins = [1], amount = 1
 * Output: 1
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: coins = [1], amount = 2
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
 public int coinChange(int[] coins, int amount) {
  if (amount == 0) {
   return 0;
  }
  int[] dp = new int[amount + 1];
  for (int coin : coins) {
   for (int i = coin; i <= amount; i++) {
    if (i == coin) {
     dp[i] = 1;
    } else if (dp[i] == 0 && dp[i - coin] != 0) {
     dp[i] = dp[i - coin] + 1;
    } else if (dp[i - coin] != 0) {
     dp[i] = Math.min(dp[i], dp[i - coin] + 1);
    }
   }
  }
  return dp[amount] == 0 ? -1 : dp[amount];
 }
}
// @lc code=end
// 零钱为完全背包问题，v为正序
