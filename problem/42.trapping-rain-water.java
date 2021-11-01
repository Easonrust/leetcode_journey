/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
 public int trap(int[] height) {
  int n = height.length;
  int[] leftMax = new int[n];
  int[] rightMax = new int[n];
  int res = 0;

  // Base Case
  leftMax[0] = height[0];
  rightMax[n - 1] = height[n - 1];

  for (int i = 1; i < n; ++i) {
   leftMax[i] = Math.max(height[i], leftMax[i - 1]);
  }

  for (int i = n - 2; i >= 0; --i) {
   rightMax[i] = Math.max(height[i], rightMax[i + 1]);
  }

  for (int i = 0; i < n; ++i) {
   res += Math.min(leftMax[i], rightMax[i]) - height[i];
  }
  return res;
 }
}

// 暴力的方法，当前格子所能承载的水量，为左右两侧最高的水中取较小的高度，减去自己的高度
// 暴力的方法中对于每个格子，我们都要重新算一遍左右两侧最高的高度，但是使用dp，可以提前把这些高度算好存起来
// @lc code=end
