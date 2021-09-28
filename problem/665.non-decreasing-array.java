/*
 * @lc app=leetcode id=665 lang=java
 *
 * [665] Non-decreasing Array
 *
 * https://leetcode.com/problems/non-decreasing-array/description/

*/

// @lc code=start
class Solution {
 public boolean checkPossibility(int[] nums) {
  int cnt = 0;
  for (int i = 1; i < nums.length; ++i) {
   if (nums[i] >= nums[i - 1]) {
    continue;
   }
   cnt++;
   if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
    nums[i] = nums[i - 1];
   } else {
    nums[i - 1] = nums[i];
   }
  }
  return cnt <= 1;
 }
}
// @lc code=end
// 注意非递减包含了等于
// 优先使nums[i-1]=nums[i],防止nums[i]变大，影响后面的操作
// 当nums[i-1]>nums[i]时，只有nums[i]=nums[i-1]才能符合要求
