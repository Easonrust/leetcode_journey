import java.util.ArrayList;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (50.93%)
 * Likes:    6944
 * Dislikes: 559
 * Total Accepted:    910.8K
 * Total Submissions: 1.8M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

// @lc code=start
class Solution {
 String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
 List<String> res;

 public List<String> letterCombinations(String digits) {
  res = new ArrayList<>();
  int n = digits.length();
  if (n == 0) {
   return res;
  }
  StringBuilder sb = new StringBuilder();
  findCombinations(sb, n, digits);
  return res;
 }

 public void findCombinations(StringBuilder sb, int n, String digits) {
  if (sb.length() == n) {
   res.add(sb.toString());
   return;
  }

  int curNum = digits.charAt(sb.length()) - '0';
  for (char c : keys[curNum].toCharArray()) {
   sb.append(c);
   findCombinations(sb, n, digits);
   sb.deleteCharAt(sb.length() - 1);
  }

 }
}

// backtracking review
// @lc code=end
