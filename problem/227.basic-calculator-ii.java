/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
 public int calculate(String s) {
  if (s == null || s.isEmpty()) {
   return 0;
  }

  int len = s.length();
  Stack<Integer> stack = new Stack<>();
  int preOperation = '+';
  int curNumber = 0;

  for (int i = 0; i < len; ++i) {
   char curChar = s.charAt(i);
   if (Character.isDigit(curChar)) {
    curNumber = curNumber * 10 + (curChar - '0');
   }

   if ((!Character.isWhitespace(curChar) && !Character.isDigit(curChar)) || i == len - 1) {
    if (preOperation == '+') {
     stack.push(curNumber);
    } else if (preOperation == '-') {
     stack.push(-curNumber);
    } else if (preOperation == '*') {
     stack.push(stack.pop() * curNumber);
    } else if (preOperation == '/') {
     stack.push(stack.pop() / curNumber);
    }
    preOperation = curChar;
    curNumber = 0;
   }
  }

  int res = 0;
  while (!stack.isEmpty()) {
   res += stack.pop();
  }

  return res;
 }
}

// 注意字符串末尾可能有空格
// @lc code=end
