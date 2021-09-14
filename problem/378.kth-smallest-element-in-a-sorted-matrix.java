/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (57.93%)
 * Likes:    4619
 * Dislikes: 208
 * Total Accepted:    318K
 * Total Submissions: 545.9K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * Given an n x n matrix where each of the rows and columns are sorted in
 * ascending order, return the k^th smallest element in the matrix.
 * 
 * Note that it is the k^th smallest element in the sorted order, not the k^th
 * distinct element.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
 * the 8^th smallest number is 13
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[-5]], k = 1
 * Output: -5
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == matrix.length
 * n == matrix[i].length
 * 1 <= n <= 300
 * -10^9 <= matrix[i][j] <= 10^9
 * All the rows and columns of matrix are guaranteed to be sorted in
 * non-decreasing order.
 * 1 <= k <= n^2
 * 
 * 
 */

// @lc code=start
class Solution {
 public int kthSmallest(int[][] matrix, int k) {
  int m = matrix.length, n = matrix[0].length;
  int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
  while (lo <= hi) {
   int mid = lo + (hi - lo) / 2;
   int cnt = 0;
   for (int i = 0; i < m; ++i) {
    for (int j = 0; j < n; ++j) {
     if (matrix[i][j] <= mid) {
      cnt++;
     } else {
      break;
     }
    }
   }
   if (cnt < k) {
    lo = mid + 1;
   } else {
    hi = mid - 1;
   }
  }
  return lo;
 }
}
// @lc code=end
// 这道题的理解，当有符合条件cnt=k的mid出现之后，lo和hi的工作是无限接近正好符合cnt=k的分界线，而分界线就是我们要求的元素
