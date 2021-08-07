/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (50.76%)
 * Likes:    9588
 * Dislikes: 263
 * Total Accepted:    1.1M
 * Total Submissions: 2.3M
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","1","1","0"],
 * ⁠ ["1","1","0","1","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: grid = [
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["1","1","0","0","0"],
 * ⁠ ["0","0","1","0","0"],
 * ⁠ ["0","0","0","1","1"]
 * ]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 * 
 * 
 */

// @lc code=start
class Solution {
    private int m, n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islandNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, i, j) > 0) {
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private int dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
            return 0;
        }
        int area = 1;
        int[][] direction = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        grid[x][y] = '0';
        for (int[] d : direction) {
            area += dfs(grid, x + d[0], y + d[1]);
        }
        return area;
    }
}
// @lc code=end
