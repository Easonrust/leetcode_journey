/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (45.36%)
 * Likes:    5140
 * Dislikes: 97
 * Total Accepted:    319K
 * Total Submissions: 701.6K
 * Testcase Example:  '[1,5,11,5]'
 *
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean canPartition(int[] nums) {
  int sum = computeArraySum(nums);
  if (nums.length == 1 || sum % 2 != 0) {
   return false;
  }
  int W = sum / 2;
  boolean[] dp = new boolean[W + 1];
  dp[0] = true;
  for (int num : nums) {
   for (int j = W; j >= 1; j--) {
    if (j >= num) {
     dp[j] = dp[j] || dp[j - num];
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
// dp[i][j] 表示是否可以从前i个数字中，选出来若干个数，和为j，转移方程就是

// dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]

// 背包问题要使用倒序j，防止dp[j-num]覆盖了dp
// 这里还不太清楚理解，要仔细再看一下
