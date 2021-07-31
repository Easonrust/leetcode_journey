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
  int delete = 0;
  if (i == j) {
   return true;
  }
  while (i <= j) {
   char c1 = s.charAt(i);
   char c2 = s.charAt(i + 1);
   char c3 = s.charAt(j - 1);
   char c4 = s.charAt(j);
   if (c1 == c4) {
    i++;
    j--;
   } else if (delete == 0) {
    delete = 1;
    if (c1 == c3 && checkPalindrome(i, j - 1, s)) {
     j--;
    } else if (c2 == c4 && checkPalindrome(i + 1, j, s)) {
     i++;
    } else {
     return false;
    }
    i++;
    j--;
   } else {
    return false;
   }
  }
  return true;
 }

 public boolean checkPalindrome(int i, int j, String s) {
  while (i <= j) {
   char c1 = s.charAt(i);
   char c2 = s.charAt(j);
   if (c1 == c2) {
    i++;
    j--;
   } else {
    return false;
   }
  }
  return true;
 }
}
// @lc code=end
