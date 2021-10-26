/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
 public int longestSubstring(String s, int k) {
  return findLongestSubstring(s, 0, s.length(), k);
 }

 public int findLongestSubstring(String s, int start, int end, int k) {
  int[] cnt = new int[26];
  for (char c : s.substring(start, end).toCharArray()) {
   cnt[c - 'a']++;
  }

  for (int i = start; i < end; ++i) {
   if (cnt[s.charAt(i) - 'a'] >= k) {
    continue;
   }

   return Math.max(findLongestSubstring(s, start, i, k), findLongestSubstring(s, i + 1, end, k));
  }
  return end - start;
 }
}

// 分治法，202复习
// @lc code=end
