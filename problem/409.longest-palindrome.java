/*
 * @lc app=leetcode id=409 lang=java
 *
 * [409] Longest Palindrome
 *
 * https://leetcode.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (52.48%)
 * Likes:    1876
 * Dislikes: 119
 * Total Accepted:    219K
 * Total Submissions: 416.8K
 * Testcase Example:  '"abccccdd"'
 *
 * Given a string s which consists of lowercase or uppercase letters, return
 * the length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a"
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "bb"
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int longestPalindrome(String s) {
  int[] cnts = new int[256];
  for (char c : s.toCharArray()) {
   cnts[c]++;
  }
  int palindromeLength = 0;
  for (int cnt : cnts) {
   palindromeLength += cnt / 2 * 2;
  }

  // 在该种情况下为奇数，所以可以把多出来的一个放中间组成回文字符串
  if (palindromeLength < s.length()) {
   palindromeLength++;
  }
  return palindromeLength;
 }
}
// @lc code=end
