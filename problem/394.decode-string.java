/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
 int idx = 0;

 public String decodeString(String s) {
  StringBuilder res = new StringBuilder();

  while (idx < s.length() && s.charAt(idx) != ']') {
   // if not digit, just append
   if (!Character.isDigit(s.charAt(idx))) {
    res.append(s.charAt(idx));

    // 因此上面要判断']',标志字符串的结束
    idx++;
   } else {
    int k = 0;

    // calculate the digit
    while (Character.isDigit(s.charAt(idx))) {
     k = k * 10 + s.charAt(idx) - '0';
     idx++;
    }

    // '[' will follow the digit, so skip it
    idx++;

    String inString = decodeString(s);

    // ']' will follow the string
    idx++;

    while (k-- > 0) {
     res.append(inString);
    }
   }
  }
  return res.toString();
 }
}
// @lc code=end
