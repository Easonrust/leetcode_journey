/*
 * @lc app=leetcode id=1137 lang=java
 *
 * [1137] N-th Tribonacci Number
 */

// @lc code=start
class Solution {
 public int tribonacci(int n) {
  int a = 0, b = 1, c = 1;
  while (n-- > 0) {
   int d = a + b + c;
   a = b;
   b = c;
   c = d;
  }
  return a;
 }
}
// @lc code=end
