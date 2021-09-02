import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=594 lang=java
 *
 * [594] Longest Harmonious Subsequence
 *
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 *
 * algorithms
 * Easy (51.66%)
 * Likes:    1290
 * Dislikes: 136
 * Total Accepted:    102.9K
 * Total Submissions: 198.5K
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * We define a harmonious array as an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Given an integer array nums, return the length of its longest harmonious
 * subsequence among all its possible subsequences.
 * 
 * A subsequence of array is a sequence that can be derived from the array by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3,4]
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,1,1,1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * 
 */

// @lc code=start
class Solution {
 public int findLHS(int[] nums) {
  Map<Integer, Integer> countForNum = new HashMap<>();

  // 每种元素重复的个数
  for (int num : nums) {
   countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
  }

  int longest = 0;
  for (int num : nums) {
   if (countForNum.containsKey(num + 1)) {
    longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
   }
  }

  return longest;
 }
}
// @lc code=end
// 和谐队列中仅有最小值和最大值两种元素
