/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
 public boolean wordPattern(String pattern, String s) {
  Map<Character, String> map = new HashMap<>();
  String[] sArr = s.split(" ");
  char[] pArr = pattern.toCharArray();

  int m = sArr.length;
  int n = pArr.length;
  if (m != n) {
   return false;
  }

  int i = 0;
  while (i < m) {
   if (!map.containsKey(pArr[i])) {

    // 双射要一一对应，值这里也要检查
    if (map.containsValue(sArr[i])) {
     return false;
    }
    map.put(pArr[i], sArr[i]);
   } else {
    if (!map.get(pArr[i]).equals(sArr[i])) {
     return false;
    }
   }

   i++;
  }

  return true;

 }
}
// @lc code=end
