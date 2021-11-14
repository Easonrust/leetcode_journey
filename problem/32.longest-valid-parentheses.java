/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
 public int longestValidParentheses(String s) {
  Stack<Integer> stack = new Stack<>();
  char[] chs = s.toCharArray();
  int res = 0;
  stack.push(-1);
  for (int i = 0; i < chs.length; ++i) {
   if (chs[i] == '(') {
    stack.push(i);
   } else if (chs[i] == ')') {
    stack.pop();
    if (stack.empty()) {
     stack.push(i);
    } else {
     res = Math.max(res, i - stack.peek());
    }
   }
  }
  return res;

 }
}

// 和valid parentheses不同，这里的stack存的是index了，抄的题解。。。
// @lc code=end
