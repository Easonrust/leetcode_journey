import java.util.Arrays;

/*
 * @lc app=leetcode id=413 lang=java
 *
 * [413] Arithmetic Slices
 *
 * https://leetcode.com/problems/arithmetic-slices/description/
 *
 * algorithms
 * Medium (60.34%)
 * Likes:    2002
 * Dislikes: 208
 * Total Accepted:    140.5K
 * Total Submissions: 232.6K
 * Testcase Example:  '[1,2,3,4]'
 *
 * An integer array is called arithmetic if it consists of at least three
 * elements and if the difference between any two consecutive elements is the
 * same.
 * 
 * 
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic
 * sequences.
 * 
 * 
 * Given an integer array nums, return the number of arithmetic subarrays of
 * nums.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and
 * [1,2,3,4] itself.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
 public int numberOfArithmeticSlices(int[] nums) {
  int[] dp = new int[nums.length];
  Arrays.fill(dp, 0);
  for (int i = 2; i < nums.length; ++i) {
   if ((nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2])) {
    dp[i] = dp[i - 1] + 1;
   }
  }
  int sum = 0;
  for (int i = 0; i < dp.length; i++) {
   sum += dp[i];
  }
  return sum;
 }
}
// @lc code=end
// 找规律
// dp[2] = 1
// [0, 1, 2]
// dp[3] = dp[2] + 1 = 2
// [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
// [1, 2, 3] // 新的递增子区间
// dp[4] = dp[3] + 1 = 3
// [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
// [1, 2, 3, 4], // [1, 2, 3] 之后加一个 4
// [2, 3, 4] // 新的递增子区间
