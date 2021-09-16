/*
 * @lc app=leetcode id=769 lang=java
 *
 * [769] Max Chunks To Make Sorted
 *
 * https://leetcode.com/problems/max-chunks-to-make-sorted/description/
 *
 * algorithms
 * Medium (56.32%)
 * Likes:    1358
 * Dislikes: 152
 * Total Accepted:    56.6K
 * Total Submissions: 99.8K
 * Testcase Example:  '[4,3,2,1,0]'
 *
 * You are given an integer array arr of length n that represents a permutation
 * of the integers in the range [0, n - 1].
 * 
 * We split arr into some number of chunks (i.e., partitions), and individually
 * sort each chunk. After concatenating them, the result should equal the
 * sorted array.
 * 
 * Return the largest number of chunks we can make to sort the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1,
 * 2], which isn't sorted.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of
 * chunks possible.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * All the elements of arr are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int maxChunksToSorted(int[] arr) {
  int ret = 0;
  int max = arr[0];
  for (int i = 0; i < arr.length; ++i) {
   max = Math.max(max, arr[i]);
   if (max == i) {
    ret++;
   }
  }
  return ret;
 }
}
// @lc code=end
// 注意数组是从0开始的，当i位置的元素恰好等于前i个元素的最大值时，可以在此处分割
