/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 *
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 *
 * algorithms
 * Medium (46.21%)
 * Likes:    8538
 * Dislikes: 183
 * Total Accepted:    629.6K
 * Total Submissions: 1.4M
 * Testcase Example:  '[10,9,2,5,3,7,101,18]'
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 * 
 * A subsequence is a sequence that can be derived from an array by deleting
 * some or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore
 * the length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time
 * complexity?
 * 
 */

// @lc code=start
class Solution {
 public int lengthOfLIS(int[] nums) {
  int n = nums.length;
  int[] dp = new int[n];
  for (int i = 0; i < n; ++i) {
   int max = 1;
   for (int j = 0; j < i; ++j) {
    if (nums[j] < nums[i]) {
     max = Math.max(max, dp[j] + 1);
    }
   }
   dp[i] = max;
  }
  int max = 0;
  for (int i = 0; i < n; ++i) {
   max = Math.max(max, dp[i]);
  }
  return max;
 }
}
// @lc code=end
// 可以使用二分查找的方式对时间复杂度进行优化
