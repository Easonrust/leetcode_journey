/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
 public boolean isPalindrome(String s) {
  int i = 0;
  int j = s.length() - 1;

  while (i < j) {
   while (i < j && !(Character.isLetterOrDigit(s.charAt(i)))) {
    i++;
   }

   while (i < j && !(Character.isLetterOrDigit(s.charAt(j)))) {
    j--;
   }

   if (i == j) {
    break;
   }

   if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
    i++;
    j--;
   } else {
    return false;
   }
  }
  return true;
 }
}

// 双指针简单题
// @lc code=end
