/*
 * @lc app=leetcode id=1465 lang=java
 *
 * [1465] Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */

// @lc code=start
class Solution {
 public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
  Arrays.sort(horizontalCuts);
  Arrays.sort(verticalCuts);
  long maxH = horizontalCuts[0] - 0;
  for (int i = 1; i < horizontalCuts.length; ++i) {
   maxH = Math.max(maxH, horizontalCuts[i] - horizontalCuts[i - 1]);
  }
  maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
  long maxV = verticalCuts[0] - 0;
  for (int i = 1; i < verticalCuts.length; ++i) {
   maxV = Math.max(maxV, verticalCuts[i] - verticalCuts[i - 1]);
  }
  maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
  return (int) (maxH * maxV % (1000000007));
 }
}
// 注意要先对数组进行排序，并且要注意类型转换
// @lc code=end
