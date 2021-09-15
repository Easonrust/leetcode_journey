/*
 * @lc app=leetcode id=667 lang=java
 *
 * [667] Beautiful Arrangement II
 *
 * https://leetcode.com/problems/beautiful-arrangement-ii/description/
 *
 * algorithms
 * Medium (58.99%)
 * Likes:    608
 * Dislikes: 919
 * Total Accepted:    44.9K
 * Total Submissions: 76K
 * Testcase Example:  '3\n1'
 *
 * Given two integers n and k, construct a list answer that contains n
 * different positive integers ranging from 1 to n and obeys the following
 * requirement:
 * 
 * 
 * Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 -
 * a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
 * integers.
 * 
 * 
 * Return the list answer. If there multiple valid answers, return any of
 * them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, k = 1
 * Output: [1,2,3]
 * Explanation: The [1,2,3] has three different positive integers ranging from
 * 1 to 3, and the [1,1] has exactly 1 distinct integer: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3, k = 2
 * Output: [1,3,2]
 * Explanation: The [1,3,2] has three different positive integers ranging from
 * 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k < n <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
 public int[] constructArray(int n, int k) {
  int[] ret = new int[n];
  ret[0] = 1;
  for (int i = 1, interval = k; i <= k; i++, interval--) {
   ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
  }

  for (int i = k + 1; i < n; ++i) {
   ret[i] = i + 1;
  }
  return ret;
 }
}
// @lc code=end
// 让前 k+1 个元素构建出 k 个不相同的差值，序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1
// 后面的经过验证可以保证k+2-(k/2+1)=k/2+1，而这个数一定是出现过的
