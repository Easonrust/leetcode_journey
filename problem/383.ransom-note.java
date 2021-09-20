/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
 public boolean canConstruct(String ransomNote, String magazine) {
  int[] cidx = new int[26];
  for (int i = 0; i < magazine.length(); ++i) {
   int idx = magazine.charAt(i) - 'a';
   cidx[idx]++;
  }
  for (int i = 0; i < ransomNote.length(); ++i) {
   int idx = ransomNote.charAt(i) - 'a';
   if (cidx[idx] == 0) {
    return false;
   }
   cidx[idx]--;
  }
  return true;
 }
}
// @lc code=end
// 用一个大小为26的数组存储字符即可
