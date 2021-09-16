import java.util.HashMap;
import java.util.Map;

import javax.sql.rowset.FilteredRowSet;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 *
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (54.87%)
 * Likes:    1571
 * Dislikes: 1068
 * Total Accepted:    123.8K
 * Total Submissions: 225K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation: 
 * The input array has a degree of 2 because both elements 1 and 2 appear
 * twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation: 
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findShortestSubArray(int[] nums) {
  Map<Integer, Integer> numsCnt = new HashMap<>();
  Map<Integer, Integer> firstIdx = new HashMap<>();
  Map<Integer, Integer> lastIdx = new HashMap<>();
  for (int i = 0; i < nums.length; ++i) {
   numsCnt.put(nums[i], numsCnt.getOrDefault(nums[i], 0) + 1);
   lastIdx.put(nums[i], i);
   if (!firstIdx.containsKey(nums[i])) {
    firstIdx.put(nums[i], i);
   }
  }
  int maxCnt = 0;
  for (int num : nums) {
   maxCnt = Math.max(maxCnt, numsCnt.get(num));
  }
  int res = nums.length;
  for (int num : nums) {
   if (maxCnt == numsCnt.get(num)) {
    res = Math.min(res, lastIdx.get(num) - firstIdx.get(num) + 1);
   }
  }
  return res;
 }
}
// @lc code=end
// 使用三个哈希表记录每个数字出现的次数，以及横跨的范围
