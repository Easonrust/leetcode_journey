import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 *
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (60.17%)
 * Likes:    6337
 * Dislikes: 383
 * Total Accepted:    969.4K
 * Total Submissions: 1.6M
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * Given an integer array nums and an integer k, return the k^th largest
 * element in the array.
 * 
 * Note that it is the k^th largest element in the sorted order, not the k^th
 * distinct element.
 * 
 * 
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findKthLargest(int[] nums, int k) {
  Arrays.sort(nums);
  return nums[nums.length - k];
 }
}
// @lc code=end
// 数组的length是一个数据成员
// 这里使用快排的话速度会更快，要复习一下快排