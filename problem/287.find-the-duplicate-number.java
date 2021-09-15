/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 *
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * algorithms
 * Medium (58.13%)
 * Likes:    9369
 * Dislikes: 954
 * Total Accepted:    610.7K
 * Total Submissions: 1M
 * Testcase Example:  '[1,3,4,2,2]'
 *
 * Given an array of integers nums containing n + 1 integers where each integer
 * is in the range [1, n] inclusive.
 * 
 * There is only one repeated number in nums, return this repeated number.
 * 
 * You must solve the problem without modifying the array nums and uses only
 * constant extra space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 * Input: nums = [1,1,2]
 * Output: 1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer
 * which appears two or more times.
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findDuplicate(int[] nums) {
  int l = 1, h = nums.length - 1;
  while (l <= h) {
   int mid = l + (h - l) / 2;
   int cnt = 0;
   for (int i = 0; i < nums.length; ++i) {
    if (nums[i] <= mid) {
     cnt++;
    }
   }

   // 寻找的结果是最异常的那个边界[，左包含

   // 异常
   if (cnt > mid) {
    h = mid - 1;
   } else {

    // 找到的那个地方一定是正常的右极限加1的地方
    l = mid + 1;
   }
  }
  return l;
 }
}
// @lc code=end
// 本题可参考378题，依然是无限逼近的情况
