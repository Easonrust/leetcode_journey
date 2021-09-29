/*
 * @lc app=leetcode id=1326 lang=java
 *
 * [1326] Minimum Number of Taps to Open to Water a Garden
 */

// @lc code=start
class Solution {
 public int minTaps(int n, int[] ranges) {
  int min = 0;
  int max = 0;
  int taps = 0;
  while (max < n) {

   for (int i = 0; i < ranges.length; i++) {
    if (i - ranges[i] <= min && i + ranges[i] >= max) {
     max = i + ranges[i]; // one tap which covers both min and max
    }
   }
   if (min == max) {
    return -1;
   }
   // once we found the min covering we have to find the tap which
   // covers the new min --> that is max covered until now
   min = max;
   taps++;
  }
  return taps;
 }
}
// @lc code=end
