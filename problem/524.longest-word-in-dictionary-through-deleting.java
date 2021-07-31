/*
 * @lc app=leetcode id=524 lang=java
 *
 * [524] Longest Word in Dictionary through Deleting
 *
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
 *
 * algorithms
 * Medium (50.41%)
 * Likes:    1103
 * Dislikes: 306
 * Total Accepted:    111.2K
 * Total Submissions: 220.6K
 * Testcase Example:  '"abpcplea"\n["ale","apple","monkey","plea"]'
 *
 * Given a string s and a string array dictionary, return the longest string in
 * the dictionary that can be formed by deleting some of the given string
 * characters. If there is more than one possible result, return the longest
 * word with the smallest lexicographical order. If there is no possible
 * result, return the empty string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
 public String findLongestWord(String s, List<String> dictionary) {
  String longestWord = "";
  for (String target : dictionary) {
   int l1 = longestWord.length();
   int l2 = target.length();
   if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
    continue;
   }

   if (isSubstr(s, target)) {
    longestWord = target;
   }
  }
  return longestWord;
 }

 // 用双指针法判断target是否为s的子序列
 public boolean isSubstr(String s, String target) {
  int i = 0, j = 0;
  while (i < s.length()) {
   if (s.charAt(i) == target.charAt(j)) {
    i++;
    j++;
   } else {
    i++;
   }
   if (j == target.length()) {
    return true;
   }
  }
  return false;
 }
}
// @lc code=end
