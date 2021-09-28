/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
 public boolean canJump(int[] nums) {
  int mx = 0;
  for (int i = 0; i < nums.length; ++i) {
   if (mx < i) {
    return false;
   }
   mx = Math.max(mx, i + nums[i]);
  }
  return true;
 }
}
// @lc code=end
// 贪心算法求mx，即能跳到的最远的位置
