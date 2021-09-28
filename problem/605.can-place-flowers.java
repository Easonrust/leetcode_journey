/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 *
*/

// @lc code=start
class Solution {
 public boolean canPlaceFlowers(int[] flowerbed, int n) {
  int cnt = 0;
  int len = flowerbed.length;
  for (int i = 0; i < len; ++i) {
   if (flowerbed[i] == 1) {
    continue;
   }
   int pre = i == 0 ? 0 : flowerbed[i - 1];
   int next = i == (len - 1) ? 0 : flowerbed[i + 1];
   if (pre == 0 && next == 0) {
    flowerbed[i] = 1;
    cnt++;
   }
  }
  return cnt >= n;
 }
}
// @lc code=end
