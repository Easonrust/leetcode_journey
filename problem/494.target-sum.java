/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 *
 * https://leetcode.com/problems/target-sum/description/
 *
 * algorithms
 * Medium (45.49%)
 * Likes:    4912
 * Dislikes: 191
 * Total Accepted:    264.9K
 * Total Submissions: 582.9K
 * Testcase Example:  '[1,1,1,1,1]\n3'
 *
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the
 * integers.
 * 
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * 
 * 
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be
 * target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1], target = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findTargetSumWays(int[] nums, int target) {
  int sum = computeArraySum(nums);
  if (sum < target || (sum + target) % 2 != 0) {
   return 0;
  }
  int W = (sum + target) / 2;
  int[] dp = new int[W + 1];
  dp[0] = 1;
  for (int num : nums) {
   for (int j = W; j >= 0; j--) {
    if (j >= num) {
     dp[j] = dp[j] + dp[j - num];
    }
   }
  }
  return dp[W];
 }

 private int computeArraySum(int[] nums) {
  int sum = 0;
  for (int num : nums) {
   sum += num;
  }
  return sum;
 }
}
// @lc code=end
// sum(P) - sum(N) = target
// sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
// 2 * sum(P) = target + sum(nums)
// 一些题经过一定的数学推导可以转换为0-1背包问题
// 注意j的最小值
