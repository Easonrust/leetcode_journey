/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 *
 * https://leetcode.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (51.10%)
 * Likes:    6200
 * Dislikes: 332
 * Total Accepted:    732.4K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * 
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 * 
 * 
 * 
 * Follow up: Could you come up with a one-pass algorithm using only constant
 * extra space?
 * 
 */

// @lc code=start
class Solution {
 public void sortColors(int[] nums) {
  int zero = -1, one = 0, two = nums.length;
  while (one < two) {
   if (nums[one] == 0) {
    zero++; // provide space for zero member
    swap(nums, zero, one);
    one++;
   } else if (nums[one] == 2) {
    two--;
    swap(nums, two, one);
   } else {
    one++;
   }
  }

 }

 private void swap(int[] nums, int i, int j) {
  int t = nums[i];
  nums[i] = nums[j];
  nums[j] = t;
 }
}
// @lc code=end
