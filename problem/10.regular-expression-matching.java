/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
 public boolean isMatch(String text, String pattern) {
  // 只有当text和pattern都完事了，才说明匹配

  if (pattern.isEmpty()) {
   return text.isEmpty();
  }

  boolean firstMatch = false;
  if (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.')) {
   firstMatch = true;
  }

  if (pattern.length() >= 2 && pattern.charAt(1) == '*') {

   // 第一个被匹配上了和第一个没被匹配上的情况
   if (isMatch(text, pattern.substring(2))) {
    return true;
   } else if (firstMatch && isMatch(text.substring(1), pattern)) {
    return true;
   }
   return false;
  } else {
   if (firstMatch && isMatch(text.substring(1), pattern.substring(1))) {
    return true;
   }
  }
  return false;
 }
}
// @lc code=end
