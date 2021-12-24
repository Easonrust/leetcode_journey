/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
 public String minWindow(String s, String t) {
  int l = 0;
  int r = 0;
  int n = s.length();
  String res = "";
  int minLength = Integer.MAX_VALUE;

  // 先记录下来t中各字符出现的次数
  Map<Character, Integer> map1 = new HashMap<>();
  for (char c : t.toCharArray()) {
   map1.put(c, map1.getOrDefault(c, 0) + 1);
  }

  Map<Character, Integer> map2 = new HashMap<>();

  while (r <= n) {
   String temp = s.substring(l, r);
   if (checkSubstring(map1, map2)) {
    if (temp.length() < minLength) {
     minLength = temp.length();
     res = temp;
    }
    char c = s.charAt(l);
    map2.put(c, map2.get(c) - 1);
    l++;
   } else {
    if (r < n) {
     char c = s.charAt(r);
     map2.put(c, map2.getOrDefault(c, 0) + 1);
    }
    r++;
   }
  }

  return res;
 }

 private boolean checkSubstring(Map<Character, Integer> map1, Map<Character, Integer> map2) {

  for (char c : map1.keySet()) {
   if (!map2.containsKey(c)) {
    return false;
   }

   if (map1.get(c) > map2.get(c)) {
    return false;
   }
  }
  return true;
 }
}
// @lc code=end
// 滑动窗口，注意数组越界
