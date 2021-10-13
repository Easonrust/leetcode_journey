/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
 public int[][] kClosest(int[][] points, int k) {
  Arrays.sort(points, new Comparator<>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    return (o1[0] * o1[0] + o1[1] * o1[1]) - (o2[0] * o2[0] + o2[1] * o2[1]);
   }
  });
  int[][] res = new int[k][2];
  for (int i = 0; i < k; ++i) {
   res[i][0] = points[i][0];
   res[i][1] = points[i][1];
  }
  return res;
 }
}
// @lc code=end
