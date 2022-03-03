// @lc code=start
class Solution {
 public int maxSubArray(int[] nums) {
  int maxSum = nums[0], preSum = nums[0];
  for (int i = 1; i < nums.length; ++i) {
   preSum = preSum > 0 ? preSum + nums[i] : nums[i];
   maxSum = Math.max(maxSum, preSum);
  }
  return maxSum;
 }
}
// @lc code=end
// 有点像股票那题
// 贪心算法解题
