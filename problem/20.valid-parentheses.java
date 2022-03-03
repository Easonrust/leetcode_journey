import java.util.Stack;
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
