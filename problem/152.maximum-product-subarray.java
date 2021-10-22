/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
 public int maxProduct(int[] nums) {

  int pproduct = nums[0];
  int nproduct = nums[0];
  int res = nums[0];
  for (int i = 1; i < nums.length; ++i) {
   int cur = nums[i];
   int temp_max = Math.max(cur, Math.max(pproduct * cur, nproduct * cur));

   nproduct = Math.min(cur, Math.min(pproduct * cur, nproduct * cur));
   pproduct = temp_max;
   res = Math.max(temp_max, res);
  }
  return res;
 }
}

// dp
// @lc code=end
