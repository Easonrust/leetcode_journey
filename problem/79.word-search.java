/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 *
 * https://leetcode.com/problems/word-search/description/
 *
 * algorithms
 * Medium (38.01%)
 * Likes:    6478
 * Dislikes: 257
 * Total Accepted:    720.8K
 * Total Submissions: 1.9M
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCCED"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * 
 * 
 * Follow up: Could you use search pruning to make your solution faster with a
 * larger board?
 * 
 */

// @lc code=start
class Solution {
    private int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (backTracking(0, i, j, marked, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(int curLen, int r, int c, boolean[][] marked, char[][] board, String word) {
        if (curLen == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= m || c >= n || word.charAt(curLen) != board[r][c] || marked[r][c] == true) {
            return false;
        }
        marked[r][c] = true;
        int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : direction) {
            int nr = r + d[0];
            int nc = c + d[1];
            // if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
            // continue;
            // }
            // 不能在这里判断，否则最后递归处会出错
            if (backTracking(curLen + 1, nr, nc, marked, board, word)) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;

    }
}
// @lc code=end
