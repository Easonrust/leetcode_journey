/*
 * @lc app=leetcode id=633 lang=java
 *
 * [633] Sum of Square Numbers
 *
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Medium (32.99%)
 * Likes:    759
 * Dislikes: 397
 * Total Accepted:    88.6K
 * Total Submissions: 268.5K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer c, decide whether there're two integers a and b
 * such that a^2 + b^2 = c.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: c = 3
 * Output: false
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: c = 4
 * Output: true
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: c = 2
 * Output: true
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: c = 1
 * Output: true
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= c <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean judgeSquareSum(int c) {
  int i = 0, j = (int) Math.sqrt(c);
  while (i <= j) {
   int sum = i * i + j * j;
   if (sum == c) {
    return true;
   } else if (sum < c) {
    i++;
   } else {
    j--;
   }
  }
  return false;
 }
}
// @lc code=end
// 这里使用双指针的方法两边寻找，疑问在于当将j初始化为c时，对于1000000的测试用例会出错，而初始化为c的平方根则不会出错
// 要注意这里会出现i<=j的情况
