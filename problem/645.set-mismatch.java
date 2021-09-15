/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 *
 * https://leetcode.com/problems/set-mismatch/description/
 *
 * algorithms
 * Easy (40.90%)
 * Likes:    1370
 * Dislikes: 487
 * Total Accepted:    142.5K
 * Total Submissions: 347.4K
 * Testcase Example:  '[1,2,2,4]'
 *
 * You have a set of integers s, which originally contains all the numbers from
 * 1 to n. Unfortunately, due to some error, one of the numbers in s got
 * duplicated to another number in the set, which results in repetition of one
 * number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set
 * after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return
 * them in the form of an array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Example 2:
 * Input: nums = [1,1]
 * Output: [1,2]
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
 public int[] findErrorNums(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {

   // 要多思考为什么这里不是if，而是while
   while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
    swap(nums, i, nums[i] - 1);
   }
  }
  for (int i = 0; i < nums.length; ++i) {
   if (nums[i] != i + 1) {
    return new int[] { nums[i], i + 1 };
   }
  }
  return null;
 }

 private void swap(int[] nums, int i, int j) {
  int tmp = nums[i];
  nums[i] = nums[j];
  nums[j] = tmp;
 }
}
// @lc code=end
// 本题最直接的方法是对数组进行排序，但是时间复杂度为O(N)
// 使用交换数组元素的方法，可以实现以O(N)的时间复杂度，O(1)的空间复杂度化解
