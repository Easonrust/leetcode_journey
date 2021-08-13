/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 *
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (49.15%)
 * Likes:    7634
 * Dislikes: 230
 * Total Accepted:    1.1M
 * Total Submissions: 2.2M
 * Testcase Example:  '2'
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
class Solution {
 // private int count = 0;

 // public int climbStairs(int n) {
 // climbOneStair(n);
 // return count;
 // }

 // private void climbOneStair(int target) {
 // if (target == 0) {
 // count++;
 // return;
 // }
 // for (int i = 1; i <= 2; ++i) {
 // if (target >= i) {
 // climbOneStair(target - i);
 // }
 // }
 // }
 // 单纯递归的话没有存储中间的结果，会超时
 public int climbStairs(int n) {
  if (n <= 2) {
   return n;
  }
  int pre1 = 1, pre2 = 2;
  int cnt = 0;
  for (int i = 3; i <= n; ++i) {
   cnt = pre1 + pre2;
   pre1 = pre2;
   pre2 = cnt;
  }
  return cnt;
 }
}
// @lc code=end
