/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
 public int evalRPN(String[] tokens) {
  Stack<Integer> stack = new Stack<>();

  for (String token : tokens) {
   if (!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")) {
    stack.push(Integer.valueOf(token));
    continue;
   }
   int num2 = stack.pop();
   int num1 = stack.pop();
   int res = 0;
   switch (token) {
    case "+":
     res = num1 + num2;
     break;
    case "-":
     res = num1 - num2;
     break;
    case "*":
     res = num1 * num2;
     break;
    case "/":
     res = num1 / num2;
     break;
    default:
     break;
   }
   stack.push(res);
  }

  return stack.pop();
 }
}

// 类似basic calculator，用stack解决
// @lc code=end
