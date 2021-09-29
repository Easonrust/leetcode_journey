/*
 * @lc app=leetcode id=780 lang=java
 *
 * [780] Reaching Points
 */

// @lc code=start
class Solution {
 public boolean reachingPoints(int sx, int sy, int tx, int ty) {
  while (tx >= sx && ty >= sy) {
   if (tx == ty) {
    break;
   }
   if (tx > ty) {
    if (ty > sy) {
     tx %= ty;
    } else {
     return (tx - sx) % ty == 0;
    }
   } else {
    if (tx > sx) {
     ty %= tx;
    } else {
     return (ty - sy) % tx == 0;
    }
   }
  }
  return sx == tx && sy == ty;
 }
}
// @lc code=end
// 反过来想，看能否将将 tx 和 ty 分别缩小到 sx 和 sy，因为如果tx>ty，则前一步操作一定是(x+y,y)
