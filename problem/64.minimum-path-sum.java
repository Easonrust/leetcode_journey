// @lc code=start
class Solution {
 public int minPathSum(int[][] grid) {
  int m = grid.length;
  int n = grid[0].length;
  // int left = 0, top = 0, cur = 0;
  // 因为要存中间的值以及对应的位置，所以不能这么写
  int[] dp = new int[n];
  for (int i = 0; i < m; ++i) {
   for (int j = 0; j < n; ++j) {
    if (j == 0) {
     dp[j] = dp[j];
    } else if (i == 0) {
     dp[j] = dp[j - 1];
    } else {
     dp[j] = Math.min(dp[j], dp[j - 1]);
    }
    dp[j] += grid[i][j];
   }
  }
  return dp[n - 1];
 }
}
// @lc code=end
