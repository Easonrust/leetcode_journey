/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
 public List<Integer> findAnagrams(String s, String p) {
  List<Integer> res = new ArrayList<>();
  int n1 = s.length();
  int n2 = p.length();

  if (n1 < n2) {
   return res;
  }

  int[] cs = new int[26];
  for (char c : p.toCharArray()) {
   cs[c - 'a']++;
  }

  for (int i = 0; i < n1; ++i) {
   boolean find = true;

   // right of the window
   cs[s.charAt(i) - 'a']--;

   // left of the window
   if (i >= n2) {
    cs[s.charAt(i - n2) - 'a']++;
   }

   for (int c : cs) {
    if (c != 0) {
     find = false;
     break;
    }
   }
   if (find == true) {
    res.add(i - n2 + 1);
   }
  }

  return res;
 }
}
// @lc code=end
