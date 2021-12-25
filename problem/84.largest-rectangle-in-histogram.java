/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
 public int largestRectangleArea(int[] heights) {
  Deque<Integer> stack = new ArrayDeque<>();

  // mark the end
  stack.push(-1);

  int n = heights.length;
  int res = 0;
  for (int i = 0; i < n; ++i) {
   // 当直接push heights[i]不能形成单调栈时，现将栈内的最大面积计算出来
   while ((stack.peek() != -1) && (heights[stack.peek()] >= heights[i])) {
    int curHeight = heights[stack.pop()];

    // 此时pop出的height比stack.peek()之前的都高，比stack.peek()到i的都要小，因此要像下面计算width
    int curWidth = i - stack.peek() - 1;
    res = Math.max(res, curHeight * curWidth);
   }
   stack.push(i);
  }

  while (stack.peek() != -1) {
   int curHeight = heights[stack.pop()];

   // 此时pop出的height比stack.peek()之前的都高，比stack.peek()到n的都要小，因此要像下面计算width
   int curWidth = n - stack.peek() - 1;
   res = Math.max(res, curHeight * curWidth);
  }
  return res;
 }
}

// 使用单调栈(monotone stack)，保证栈内元素是递增的，从而可以分开解决问题
// @lc code=end
