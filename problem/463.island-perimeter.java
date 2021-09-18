/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
 public int islandPerimeter(int[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  int peri = 0;
  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (grid[i][j] == 1) {
     if (i == 0 || grid[i - 1][j] == 0) {
      peri++;
     }
     if (j == 0 || grid[i][j - 1] == 0) {
      peri++;
     }
     if (i == m - 1 || grid[i + 1][j] == 0) {
      peri++;
     }
     if (j == n - 1 || grid[i][j + 1] == 0) {
      peri++;
     }
    }
   }
  }
  return peri;
 }
}
// @lc code=end
// 判断边界值即可，因为岛是相连的
