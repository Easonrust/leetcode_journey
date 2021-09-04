/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 *
 * https://leetcode.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (41.39%)
 * Likes:    2639
 * Dislikes: 548
 * Total Accepted:    421.4K
 * Total Submissions: 1M
 * Testcase Example:  '"egg"\n"add"'
 *
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to
 * get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character, but a character may map to itself.
 * 
 * 
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean isIsomorphic(String s, String t) {
  int[] preIndexOfs = new int[256];
  int[] preIndexOft = new int[256];
  for (int i = 0; i < s.length(); ++i) {
   char sc = s.charAt(i);
   char tc = t.charAt(i);
   if (preIndexOfs[sc] != preIndexOft[tc]) {
    return false;
   }
   preIndexOfs[sc] = i + 1;
   preIndexOft[tc] = i + 1;
  }
  return true;
 }
}
// @lc code=end
// 用数组存储字符上次出现的位置，如果上次出现的位置不同，不为同构
