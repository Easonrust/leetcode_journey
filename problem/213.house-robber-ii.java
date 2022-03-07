// @lc code=start
class Solution {
 public int rob(int[] nums) {

  if (nums.length == 1) {
   return nums[0];
  }
  return Math.max(robDeleteOne(nums, 0, nums.length - 2), robDeleteOne(nums, 1, nums.length - 1));
 }

 private int robDeleteOne(int[] nums, int start, int end) {
  int pre1 = 0, pre2 = 0, cur = 0;
  for (int i = start; i <= end; ++i) {
   cur = Math.max(pre1 + nums[i], pre2);
   pre1 = pre2;
   pre2 = cur;
  }
  return cur;
 }
}
// @lc code=end
// 跟线性的相比，环状的只需掐头去尾即可