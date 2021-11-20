/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
 public String minRemoveToMakeValid(String s) {
  Set<Integer> set = new HashSet<>();
  Deque<Integer> stack = new ArrayDeque<>();
  for (int i = 0; i < s.length(); ++i) {
   if (s.charAt(i) == '(') {
    stack.push(i);
   } else if (s.charAt(i) == ')') {

    // 把不符合规矩的')'的idx都装进去
    if (stack.isEmpty()) {
     set.add(i);
    } else {
     stack.pop();
    }
   }
  }

  // 把不符合规矩的'('的idx都装进去
  while (!stack.isEmpty()) {
   set.add(stack.pop());
  }

  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < s.length(); ++i) {
   if (!set.contains(i)) {
    sb.append(s.charAt(i));
   }
  }
  return sb.toString();
 }
}

// ArrayDeque可做队列或栈使用，更加高效
// @lc code=end
