import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 *
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (54.30%)
 * Likes:    4190
 * Dislikes: 130
 * Total Accepted:    342.3K
 * Total Submissions: 626.2K
 * Testcase Example:  '"aab"'
 *
 * Given a string s, partition s such that every substring of the partition is
 * a palindrome. Return all possible palindrome partitioning of s.
 * 
 * A palindrome string is a string that reads the same backward as forward.
 * 
 * 
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
 public List<List<String>> partition(String s) {
  List<List<String>> results = new ArrayList<>();
  List<String> result = new ArrayList<>();
  backTracking(s, results, result);
  return results;
 }

 private void backTracking(String s, List<List<String>> results, List<String> result) {
  if (s.length() == 0) {
   results.add(new ArrayList<>(result));
   return;
  }
  for (int i = 0; i < s.length(); ++i) {
   if (isPalindrome(s, 0, i)) {
    result.add(s.substring(0, i + 1));
    backTracking(s.substring(i + 1), results, result);
    result.remove(result.size() - 1);
   }
  }
 }

 private boolean isPalindrome(String s, int start, int end) {
  while (start < end) {
   if (s.charAt(start) != s.charAt(end)) {
    return false;
   }
   start++;
   end--;
  }
  return true;
 }
}
// @lc code=end
// 记住回文字符串的判断方式
