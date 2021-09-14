/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 *
 * https://leetcode.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (50.90%)
 * Likes:    3962
 * Dislikes: 1850
 * Total Accepted:    1.5M
 * Total Submissions: 2.9M
 * Testcase Example:  '121'
 *
 * Given an integer x, return true if x is palindrome integer.
 * 
 * An integer is a palindrome when it reads the same backward as forward. For
 * example, 121 is palindrome while 123 is not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 121
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore it is not a palindrome.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a
 * palindrome.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: x = -101
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= x <= 2^31 - 1
 * 
 * 
 * 
 * Follow up: Could you solve it without converting the integer to a string?
 */

// @lc code=start
class Solution {
 public boolean isPalindrome(int x) {
  if (x == 0) {
   return true;
  }
  if (x < 0 || x % 10 == 0) {
   return false;
  }
  int right = 0;

  // 这部分是将数字分成左右两部分，比如3223，分成32和23，再将23翻转成32
  while (x > right) {
   right = right * 10 + x % 10;
   x /= 10;
  }

  // 需要考虑数字为奇数长度的情况，即right/10
  return x == right || x == right / 10;
 }
}
// @lc code=end
