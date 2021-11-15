/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
 public int reverse(int x) {
  if (x == 0) {
   return 0;
  }

  long sign = 1;

  if (x < 0) {
   sign = -1;
   x = -x;
  }

  long res = 0;
  List<Integer> list = new ArrayList<>();

  while (x != 0) {
   list.add(x % 10);
   x /= 10;
  }

  int start = 0;
  if (list.get(0) == 0) {
   start += 1;
  }

  for (int i = start; i < list.size(); ++i) {
   res = res * 10 + (long) list.get(i);
  }

  if (res * sign > Integer.MAX_VALUE || res * sign < Integer.MIN_VALUE) {
   return 0;
  }

  return (int) sign * (int) res;
 }
}
// @lc code=end
