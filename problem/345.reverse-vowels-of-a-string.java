import java.util.Arrays;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 *
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (45.79%)
 * Likes:    1166
 * Dislikes: 1575
 * Total Accepted:    294.9K
 * Total Submissions: 643.9K
 * Testcase Example:  '"hello"'
 *
 * Given a string s, reverse only all the vowels in the string and return it.
 * 
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both
 * cases.
 * 
 * 
 * Example 1:
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * Input: s = "leetcode"
 * Output: "leotcede"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consist of printable ASCII characters.
 * 
 * 
 */

// @lc code=start
import java.util.HashSet;

class Solution {
 private final static HashSet<Character> VOWELS = new HashSet<Character>(
   Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

 public String reverseVowels(String s) {
  int i = 0, j = s.length() - 1;
  char[] result = new char[s.length()];
  while (i <= j) {
   char first_v = s.charAt(i);
   char second_v = s.charAt(j);
   if (!VOWELS.contains(first_v)) {
    result[i] = first_v;
    i++;
   } else if (!VOWELS.contains(second_v)) {
    result[j] = second_v;
    j--;
   } else {
    result[i] = second_v;
    result[j] = first_v;
    i++;
    j--;
   }
  }
  return new String(result);

 }
}
// @lc code=end
// 双指针法检测元音字母，然后交换
// 这种也要考虑i<=j的情况，因为都需要赋值
