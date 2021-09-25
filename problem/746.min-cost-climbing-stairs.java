/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
 public int minCostClimbingStairs(int[] cost) {
  int a = 0, b = 0;
  for (int i = 1; i < cost.length; ++i) {
   int c = Math.min(a + cost[i - 1], b + cost[i]);
   a = b;
   b = c;
  }
  return b;
 }
}
// @lc code=end
// 有点像斐波那契数列