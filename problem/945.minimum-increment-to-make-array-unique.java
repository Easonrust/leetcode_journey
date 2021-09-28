import java.util.Arrays;

/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start
class Solution {
 public int minIncrementForUnique(int[] nums) {
  int res = 0;
  Arrays.sort(nums);
  for (int i = 1; i < nums.length; ++i) {
   while (nums[i] <= nums[i - 1]) {
    int add = nums[i - 1] + 1 - nums[i];
    nums[i] += add;
    res += add;
   }
  }
  return res;
 }
}
// @lc code=end
