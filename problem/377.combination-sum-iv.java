import java.util.Arrays;

/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 *
 * https://leetcode.com/problems/combination-sum-iv/description/
 *
 * algorithms
 * Medium (47.40%)
 * Likes:    2586
 * Dislikes: 287
 * Total Accepted:    188.5K
 * Total Submissions: 396.9K
 * Testcase Example:  '[1,2,3]\n4'
 *
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [9], target = 3
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * 
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 */

// @lc code=start
class Solution {
 public int combinationSum4(int[] nums, int target) {
  Arrays.sort(nums);
  int[] maximum = new int[target + 1];
  maximum[0] = 1;
  for (int i = 1; i <= target; ++i) {
   for (int j = 0; j < nums.length; ++j) {
    if (nums[j] <= i) {
     maximum[i] += maximum[i - nums[j]];
    }
   }
  }
  return maximum[target];
 }
}
// @lc code=end
// 涉及顺序的完全背包问题
