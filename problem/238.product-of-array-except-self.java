/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
 public int[] productExceptSelf(int[] nums) {
  int n = nums.length;
  int[] product = new int[n];
  Arrays.fill(product, 1);

  // 把左边元素都乘一遍
  int left = 1;
  for (int i = 1; i < n; ++i) {
   left *= nums[i - 1];
   product[i] *= left;
  }

  // 把右边元素都乘一遍
  int right = 1;
  for (int i = n - 2; i >= 0; --i) {
   right *= nums[i + 1];
   product[i] *= right;
  }
  return product;
 }
}
// @lc code=end
