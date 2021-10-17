/*
 * @lc app=leetcode id=1578 lang=java
 *
 * [1578] Minimum Deletion Cost to Avoid Repeating Letters
 */

// @lc code=start
class Solution {
 public int minCost(String s, int[] cost) {
  int res = 0;
  int maxCost = 0;
  if (s.length() == 1) {
   return res;
  }
  maxCost = cost[0];
  for (int i = 1; i < s.length(); ++i) {
   if (s.charAt(i) == s.charAt(i - 1)) {
    if (maxCost <= cost[i]) {
     res += maxCost;
     maxCost = cost[i];
    } else {
     res += cost[i];
    }
   } else {
    maxCost = cost[i];
   }
  }
  return res;
 }
}

// 使用贪心算法更新一个maxCost
// @lc code=end
