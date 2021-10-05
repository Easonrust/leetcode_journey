import java.util.HashMap;

/*
 * @lc app=leetcode id=1347 lang=java
 *
 * [1347] Minimum Number of Steps to Make Two Strings Anagram
 */

// @lc code=start
class Solution {
 public int minSteps(String s, String t) {
  int[] cnts = new int[26];
  int count = 0;
  for (char c : s.toCharArray()) {
   cnts[c - 'a']++;
  }
  for (char c : t.toCharArray()) {
   cnts[c - 'a']--;
  }
  for (int cnt : cnts) {
   if (cnt > 0) {
    count += cnt;
   }
  }
  return count;
 }
}
// @lc code=end
// 与242相似