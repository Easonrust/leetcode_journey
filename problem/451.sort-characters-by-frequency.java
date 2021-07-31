/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 *
 * algorithms
 * Medium (65.34%)
 * Likes:    2679
 * Dislikes: 157
 * Total Accepted:    271.7K
 * Total Submissions: 415.6K
 * Testcase Example:  '"tree"'
 *
 * Given a string s, sort it in decreasing order based on the frequency of
 * characters, and return the sorted string.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
 * answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "cccaaa"
 * Output: "aaaccc"
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a
 * valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "Aabb"
 * Output: "bbAa"
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 5 * 10^5
 * s consists of English letters and digits.
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
 public String frequencySort(String s) {
  HashMap<Character, Integer> frequencyForChar = new HashMap<>();
  for (int i = 0; i < s.length(); i++) {
   frequencyForChar.put(s.charAt(i), frequencyForChar.getOrDefault(s.charAt(i), 0) + 1);
  }
  List<Character>[] buckets = new ArrayList[s.length() + 1];
  for (char key : frequencyForChar.keySet()) {
   int frequency = frequencyForChar.get(key);
   if (buckets[frequency] == null) {
    buckets[frequency] = new ArrayList<>();
   }
   buckets[frequency].add(key);
  }
  ArrayList<Character> resultList = new ArrayList<>();
  for (int i = buckets.length - 1; i >= 0; i--) {
   if (buckets[i] == null) {
    continue;
   }
   for (int j = 0; j < buckets[i].size(); j++) {
    for (int m = 0; m < i; m++) {
     resultList.add(buckets[i].get(j));
    }
   }
  }
  char[] resultArray = new char[s.length()];
  for (int i = 0; i < s.length(); i++) {
   resultArray[i] = resultList.get(i);
  }
  String result = new String(resultArray);
  return result;
 }
}
// @lc code=end
