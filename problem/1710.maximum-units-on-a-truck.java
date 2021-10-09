/*
 * @lc app=leetcode id=1710 lang=java
 *
 * [1710] Maximum Units on a Truck
 */

// @lc code=start
class Solution {
 public int maximumUnits(int[][] boxTypes, int truckSize) {
  Arrays.sort(boxTypes, new Comparator<>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    return o2[1] - o1[1];
   }
  });
  int res = 0;
  for (int i = 0; i < boxTypes.length; ++i) {
   for (int j = 0; j < boxTypes[i][0]; ++j) {
    res += boxTypes[i][1];
    truckSize--;
    if (truckSize == 0) {
     break;
    }
   }
   if (truckSize == 0) {
    break;
   }
  }
  return res;
 }
}
// @lc code=end
