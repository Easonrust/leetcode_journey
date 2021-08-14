import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 *
 * https://leetcode.com/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (49.95%)
 * Likes:    4893
 * Dislikes: 249
 * Total Accepted:    423.4K
 * Total Submissions: 846.3K
 * Testcase Example:  '12'
 *
 * Given an integer n, return the least number of perfect square numbers that
 * sum to n.
 * 
 * A perfect square is an integer that is the square of an integer; in other
 * words, it is the product of some integer with itself. For example, 1, 4, 9,
 * and 16 are perfect squares while 3 and 11 are not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
 // bfs解法
 // public int numSquares(int n) {
 // List<Integer> squares = generateSquares(n);
 // boolean[] marked = new boolean[n + 1];
 // Queue<Integer> queue = new LinkedList<>();
 // int pathLength = 0;
 // queue.offer(n);
 // while (!queue.isEmpty()) {
 // int size = queue.size();
 // pathLength++;
 // while (size > 0) {
 // int cur = queue.poll();
 // size--;

 // marked[cur] = true;
 // for (int square : squares) {
 // int nur = cur - square;

 // if (nur < 0 || marked[nur] == true) {
 // continue;
 // }
 // if (nur == 0) {
 // return pathLength;
 // }
 // marked[nur] = true;
 // queue.add(nur);
 // }
 // }
 // }
 // return n;
 // }

 // 动态规划解法
 public int numSquares(int n) {
  List<Integer> squares = generateSquares(n);
  int[] dp = new int[n + 1];
  Arrays.fill(dp, 0);
  for (int i = 1; i <= n; ++i) {
   int min = Integer.MAX_VALUE;
   for (int square : squares) {
    if (i < square) {
     break;
    }
    min = Math.min(min, dp[i - square] + 1);
   }
   dp[i] = min;
  }
  return dp[n];
 }

 private List<Integer> generateSquares(int n) {
  List<Integer> squares = new ArrayList<>();
  int square = 1, diff = 3;
  while (square <= n) {
   squares.add(square);
   square += diff;
   diff += 2;
  }
  return squares;
 }

}
// @lc code=end
