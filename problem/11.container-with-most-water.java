/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
 public int maxArea(int[] height) {
  int res = 0;
  int i = 0;
  int j = height.length - 1;

  while (i < j) {
   int first = height[i];
   int second = height[j];

   int originI = i;
   int originJ = j;

   if (first <= second) {
    int area = first * (j - i);
    res = Math.max(res, area);
    for (int idx = i; idx < j; ++idx) {
     if (height[idx] > first) {
      i = idx;
      break;
     }
    }
   } else {
    int area = second * (j - i);
    res = Math.max(res, area);
    for (int idx = j; idx > i; --idx) {
     if (height[idx] > second) {
      j = idx;
      break;
     }
    }
   }

   if (i == originI && j == originJ) {
    break;
   }
  }
  return res;
 }
}

// 贪心算法加双指针从两边向中间推进，注意当i和j都没有变化时，说明中间的都比他们矮，中止循环
// @lc code=end
