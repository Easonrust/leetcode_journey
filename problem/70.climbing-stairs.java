// @lc code=start
class Solution {
 // private int count = 0;

 // public int climbStairs(int n) {
 // climbOneStair(n);
 // return count;
 // }

 // private void climbOneStair(int target) {
 // if (target == 0) {
 // count++;
 // return;
 // }
 // for (int i = 1; i <= 2; ++i) {
 // if (target >= i) {
 // climbOneStair(target - i);
 // }
 // }
 // }
 // 单纯递归的话没有存储中间的结果，会超时
 public int climbStairs(int n) {
  if (n <= 2) {
   return n;
  }
  int pre1 = 1, pre2 = 2;
  int cnt = 0;
  for (int i = 3; i <= n; ++i) {
   cnt = pre1 + pre2;
   pre1 = pre2;
   pre2 = cnt;
  }
  return cnt;
 }
}
// @lc code=end
