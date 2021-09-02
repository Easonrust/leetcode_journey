import java.util.HashMap;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Medium (47.48%)
 * Likes:    6668
 * Dislikes: 308
 * Total Accepted:    495.7K
 * Total Submissions: 1M
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * Given an unsorted array of integers nums, return the length of the longest
 * consecutive elements sequence.
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
 public int longestConsecutive(int[] nums) {
  Map<Intger, Integer> countForNum = new HashMap<>();
  for (int num : nums) {
   countForNum.put(num, 1);
  }
  for (int num : nums) {
   forward(countForNum, num);
  }
  return maxCount(countForNum);
 }

 private int forward(Map<Integer, Integer> countForNum, int num) {
  if (!countForNum.containsKey(num)) {
   return 0;
  }
  int cnt = countForNum.get(num);

  // 确保每一个数字只进行过一次forward计算
  if (cnt > 1) {
   return cnt;
  }
  cnt = forward(countForNum, num + 1) + 1;
  countForNum.put(num, cnt);
  return cnt;
 }

 private int maxCount(Map<Integer, Integer> countForNum) {
  int max = 0;
  for (int num : countForNum.keySet()) {
   max = Math.max(max, countForNum.get(num));
  }
  return max;
 }
}
// @lc code=end
// 对于这种从无序队列中寻找有序序列的题目，要用hashmap的方式求解
