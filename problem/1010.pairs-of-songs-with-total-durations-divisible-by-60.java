/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
 public int numPairsDivisibleBy60(int[] time) {
  int[] timeM60 = new int[60];
  for (int t : time) {
   timeM60[t % 60]++;
  }

  int cnt = 0;
  cnt += timeM60[0] * (timeM60[0] - 1) / 2;
  cnt += timeM60[30] * (timeM60[30] - 1) / 2;
  for (int i = 1; i < 30; ++i) {
   cnt += timeM60[i] * timeM60[60 - i];
  }
  return cnt;
 }
}
// 只需计算每个数mod60，然后应用排列组合的知识
// @lc code=end
