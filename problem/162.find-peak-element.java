/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
 public int findPeakElement(int[] nums) {
  int l = 0;
  int h = nums.length - 1;

  while (l < h) {
   int mid = l + (h - l) / 2;

   if (nums[mid] < nums[mid + 1]) {
    l = mid + 1;
   } else {
    h = mid;
   }
  }
  return l;
 }
}

// 使用二分搜索，判断mid是在上坡还是下坡上来找到峰值
// @lc code=end
