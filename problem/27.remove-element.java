/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */

// @lc code=start
class Solution {
 public int removeElement(int[] nums, int val) {
  int cnt = 0, n = nums.length;
  for (int i = 0; i < n; ++i) {
   if (nums[i] == val) {
    cnt++;
   } else {
    nums[i - cnt] = nums[i];
   }
  }
  return n - cnt;
 }
}
// @lc code=end
// 本题和26题相似
