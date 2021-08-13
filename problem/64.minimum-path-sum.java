/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (57.30%)
 * Likes:    5400
 * Dislikes: 87
 * Total Accepted:    578.7K
 * Total Submissions: 1M
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its
 * path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 
 * 
 */

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
