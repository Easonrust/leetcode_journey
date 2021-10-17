/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
 public List<String> generateParenthesis(int n) {
  List<String> res = new ArrayList<>();
  StringBuilder cur = new StringBuilder();
  backTracking(cur, 0, 0, n, res);
  return res;
 }

 void backTracking(StringBuilder cur, int left, int right, int cnt, List<String> res) {
  if (cur.length() == cnt * 2) {
   res.add(cur.toString());
   return;
  }

  if (left < cnt) {
   cur.append('(');
   backTracking(cur, left + 1, right, cnt, res);
   cur.deleteCharAt(cur.length() - 1);
  }
  if (right < left) {
   cur.append(')');
   backTracking(cur, left, right + 1, cnt, res);
   cur.deleteCharAt(cur.length() - 1);
  }
  return;
 }
}
// backTracking
// @lc code=end
