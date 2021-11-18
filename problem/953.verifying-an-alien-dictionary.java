/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
 public boolean isAlienSorted(String[] words, String order) {
  for (int i = 0; i < words.length - 1; ++i) {
   String word1 = words[i];
   String word2 = words[i + 1];

   if (word1.startsWith(word2) && word1.length() > word2.length()) {
    return false;
   }

   for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
    if (word1.charAt(j) == word2.charAt(j)) {
     continue;
    }

    if (order.indexOf(word1.charAt(j)) > order.indexOf(word2.charAt(j))) {
     return false;
    } else {
     break;
    }
   }
  }

  return true;
 }
}

// 269 的基础
// @lc code=end
