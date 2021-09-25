/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (37.46%)
 * Likes:    2944
 * Dislikes: 186
 * Total Accepted:    294.1K
 * Total Submissions: 784.8K
 * Testcase Example:  '"aba"'
 *
 * Given a string s, return true if the s can be palindrome after deleting at
 * most one character from it.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "aba"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "abc"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean validPalindrome(String s) {
  int i = 0, j = s.length() - 1;
  while (i < j) {

   // 这里注意判断里面中要用到i和j的值，因此不能这样简写
   if (s.charAt(i) != s.charAt(j)) {
    return checkPalindrome(i + 1, j, s) || checkPalindrome(i, j - 1, s);
   }
   i++;
   j--;
  }
  return true;
 }

 public boolean checkPalindrome(int i, int j, String s) {
  while (i < j) {
   if (s.charAt(i++) != s.charAt(j--)) {
    return false;
   }
  }
  return true;
 }
}
// @lc code=end
