/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 *
 * https://leetcode.com/problems/count-binary-substrings/description/
 *
 * algorithms
 * Easy (61.69%)
 * Likes:    1986
 * Dislikes: 345
 * Total Accepted:    93.1K
 * Total Submissions: 149.9K
 * Testcase Example:  '"00110011"'
 *
 * Give a binary string s, return the number of non-empty substrings that have
 * the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they
 * occur.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive
 * 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * Notice that some of these substrings repeat and are counted the number of
 * times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are
 * not grouped together.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal
 * number of consecutive 1's and 0's.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is either '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int countBinarySubstrings(String s) {
  int preln = 0, curlen = 1, count = 0;
  for (int i = 1; i < s.length(); ++i) {
   if (s.charAt(i) == s.charAt(i - 1)) {
    curlen++;
   } else {
    // 重新开始数另一个数字
    preln = curlen;
    curlen = 1;
   }

   // >可以把一些子串的情况包含进去
   if (preln >= curlen) {
    count++;
   }
  }
  return count;
 }
}
// @lc code=end