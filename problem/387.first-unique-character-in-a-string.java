/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
 public int firstUniqChar(String s) {
  Map<Character, Integer> map = new HashMap<>();

  char[] chs = s.toCharArray();

  for (char ch : chs) {
   map.put(ch, map.getOrDefault(ch, 0) + 1);
  }

  for (int i = 0; i < chs.length; ++i) {
   if (map.get(chs[i]) == 1) {
    return i;
   }
  }
  return -1;
 }
}

// hashmap
// @lc code=end
