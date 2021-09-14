/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 *
 * algorithms
 * Medium (63.15%)
 * Likes:    5051
 * Dislikes: 144
 * Total Accepted:    321.9K
 * Total Submissions: 507.6K
 * Testcase Example:  '"abc"'
 *
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {

 private int cnt = 0;

 public int countSubstrings(String s) {
  for (int i = 0; i < s.length(); ++i) {
   extendString(s, i, i); // 奇数长度的回文字符串
   extendString(s, i, i + 1); // 偶数长度的回文字符串
  }
  return cnt;
 }

 private void extendString(String s, int start, int end) {
  while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
   cnt++;
   start--;
   end++;
  }
 }
}
// @lc code=end
// 将回文字符串分为奇数长度的和偶数长度的两种，从字符串的某一位开始进行扩展寻找可能的回文字符串
