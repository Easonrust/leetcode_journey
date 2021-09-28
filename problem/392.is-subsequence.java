/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 *
 * https://leetcode.com/problems/is-subsequence/description/
 *
 * 
*/

// @lc code=start
class Solution {
 public boolean isSubsequence(String s, String t) {
  int i = 0, j = 0;
  if (s.length() == 0) {
   return true;
  }
  while (i < t.length() && j < s.length()) {
   if (t.charAt(i) == s.charAt(j)) {
    j++;
   }
   i++;
  }
  return j == s.length();
 }
}
// @lc code=end
// 也可以不用贪心算法，使用双指针法一个一个比较即可
