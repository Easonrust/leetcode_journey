/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
 public String longestCommonPrefix(String[] strs) {
  int n = strs.length;
  for (int i = 0; i < strs[0].length(); ++i) {
   for (int j = 1; j < n; ++j) {
    if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
     return strs[0].substring(0, i);
    }
   }
  }

  // 对应字符串组中只有一个字符串的情况
  return strs[0];
 }
}
// @lc code=end
// 以字符串组中的第一个字符串为基准进行比较即可
