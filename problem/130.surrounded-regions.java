/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (30.77%)
 * Likes:    3215
 * Dislikes: 846
 * Total Accepted:    320.6K
 * Total Submissions: 1M
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that
 * are 4-directionally surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board =
 * [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * Output:
 * [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * Explanation: Surrounded regions should not be on the border, which means
 * that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that
 * is not on the border and it is not connected to an 'O' on the border will be
 * flipped to 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["X"]]
 * Output: [["X"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] is 'X' or 'O'.
 * 
 * 
 */

// @lc code=start
class Solution {
    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; ++i) {
            dfs(board, i, n - 1);
            dfs(board, i, 0);
        }
        for (int i = 0; i < n; ++i) {
            dfs(board, m - 1, i);
            dfs(board, 0, i);
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] d : direction) {
            dfs(board, x + d[0], y + d[1]);
        }
    }
}
// @lc code=end
