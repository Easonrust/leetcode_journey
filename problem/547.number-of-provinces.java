/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Number of Provinces
 *
 * https://leetcode.com/problems/number-of-provinces/description/
 *
 * algorithms
 * Medium (61.61%)
 * Likes:    3514
 * Dislikes: 198
 * Total Accepted:    303.8K
 * Total Submissions: 492.5K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * There are n cities. Some of them are connected, while some are not. If city
 * a is connected directly with city b, and city b is connected directly with
 * city c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no
 * other cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * i^th city and the j^th city are directly connected, and isConnected[i][j] =
 * 0 otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] is 1 or 0.
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * 
 * 
 */

// @lc code=start
class Solution {
    private int n;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean[] marked = new boolean[n];
        int num = 0;
        for (int i = 0; i < isConnected.length; ++i) {
            if (marked[i] != true) {
                num++;
                dfs(isConnected, i, marked);
            }
        }
        return num;
    }

    private void dfs(int[][] isConnected, int c, boolean[] marked) {
        marked[c] = true;
        for (int i = 0; i < n; ++i) {
            if (isConnected[c][i] == 1 && marked[i] != true) {
                dfs(isConnected, i, marked);
            }
        }
    }
}
// @lc code=end
