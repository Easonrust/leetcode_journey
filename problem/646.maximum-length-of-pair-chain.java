import java.util.Arrays;

/*
 * @lc app=leetcode id=646 lang=java
 *
 * [646] Maximum Length of Pair Chain
 *
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (54.11%)
 * Likes:    1667
 * Dislikes: 92
 * Total Accepted:    87.9K
 * Total Submissions: 161.9K
 * Testcase Example:  '[[1,2],[2,3],[3,4]]'
 *
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and
 * lefti < righti.
 * 
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can
 * be formed in this fashion.
 * 
 * Return the length longest chain which can be formed.
 * 
 * You do not need to use up all the given intervals. You can select pairs in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pairs = [[1,2],[2,3],[3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pairs = [[1,2],[7,8],[4,5]]
 * Output: 3
 * Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == pairs.length
 * 1 <= n <= 1000
 * -1000 <= lefti < righti < 1000
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findLongestChain(int[][] pairs) {
  Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
  int n = pairs.length;
  int[] dp = new int[n];
  dp[0] = 1;
  for (int i = 1; i < n; ++i) {
   int max = 1;
   for (int j = 0; j < i; ++j) {
    if (pairs[j][1] < pairs[i][0]) {
     max = Math.max(max, dp[j] + 1);
    }
   }
   dp[i] = max;
  }
  int max = 0;
  for (int i = 0; i < n; ++i) {
   max = Math.max(max, dp[i]);
  }
  return max;
 }
}
// @lc code=end
// 跟300 lIS的题类似
