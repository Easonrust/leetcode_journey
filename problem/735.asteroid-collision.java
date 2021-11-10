/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
 public int[] asteroidCollision(int[] asteroids) {
  Stack<Integer> stack = new Stack<>();

  for (int ast : asteroids) {
   while (stack.size() > 0) {
    int temp = stack.peek();
    if (temp > 0 && ast < 0) {
     if (temp == -ast) {
      stack.pop();
      ast = 0;
      break;
     } else if (Math.abs(temp) > Math.abs(ast)) {
      break;
     } else {
      stack.pop();
     }
    } else {
     stack.add(ast);
     break;
    }
   }
   if (stack.size() == 0 && ast != 0) {
    stack.add(ast);
   }
  }
  int[] res = new int[stack.size()];
  for (int i = res.length - 1; i >= 0; --i) {
   res[i] = stack.pop();
  }
  return res;
 }
}

// 使用stack模拟碰撞过程
// @lc code=end
