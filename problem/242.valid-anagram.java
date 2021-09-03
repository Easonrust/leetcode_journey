/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (59.52%)
 * Likes:    3075
 * Dislikes: 177
 * Total Accepted:    902.8K
 * Total Submissions: 1.5M
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 * 
 */

// @lc code=start
class Solution {
 public boolean isAnagram(String s, String t) {
  int[] cnts = new int[26];
  for (char c : s.toCharArray()) {
   cnts[c - 'a']++;
  }
  for (char c : t.toCharArray()) {
   cnts[c - 'a']--;
  }
  for (int cnt : cnts) {
   if (cnt != 0) {
    return false;
   }
  }
  return true;
 }
}
// @lc code=end
// 比较两字符串中各字符出现的次数是否相等即可
