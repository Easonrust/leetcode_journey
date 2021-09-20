/*
 * @lc app=leetcode id=154 lang=java
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
 public int findMin(int[] nums) {
  int l = 0, h = nums.length - 1;
  while (l < h) {
   int m = l + (h - l) / 2;
   if (nums[m] > nums[h]) {
    l = m + 1;
   } else if (nums[m] < nums[h]) {
    h = m;
   } else {
    h--;
   }
  }
  return nums[l];
 }
}
// @lc code=end
// 和153一样，都是用二分法逼近中间的边界，不同的是，如果存在元素相等的情况，需要h--
// 二分法。

// 若 nums[m] > nums[r]，说明最小值在 m 的右边；若 nums[m] < nums[r]，说明最小值在 m 的左边（包括
// m）；若相等，无法判断，直接将 r 减 1。循环比较。

// 最后返回 nums[l] 即可
