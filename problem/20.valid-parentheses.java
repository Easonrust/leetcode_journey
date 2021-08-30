import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.25%)
 * Likes:    8746
 * Dislikes: 347
 * Total Accepted:    1.6M
 * Total Submissions: 4M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: s = "([)]"
 * Output: false
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: s = "{[]}"
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean isValid(String s) {
  Stack<Character> stack = new Stack<>();
  for (char c : s.toCharArray()) {
   if (c == '(' || c == '{' || c == '[') {
    stack.add(c);
   } else {

    // 没有起始括号，也不合格
    if (stack.isEmpty()) {
     return false;
    }
    char cStack = stack.pop();
    boolean b1 = (c == ')' && cStack != '(');
    boolean b2 = (c == ']' && cStack != '[');
    boolean b3 = (c == '}' && cStack != '{');
    if (b1 || b2 || b3) {
     return false;
    }
   }
  }

  // 最后出栈不空，说明有落单的，也不合格
  return stack.isEmpty();
 }
}
// @lc code=end
