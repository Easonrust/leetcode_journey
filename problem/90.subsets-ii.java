import java.util.Arrays;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (50.07%)
 * Likes:    3279
 * Dislikes: 121
 * Total Accepted:    394.7K
 * Total Submissions: 778K
 * Testcase Example:  '[1,2,2]'
 *
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * 
 * 
 */

// @lc code=start
class Solution {
 public List<List<Integer>> subsetsWithDup(int[] nums) {
  Arrays.sort(nums);
  List<List<Integer>> results = new ArrayList<>();
  List<Integer> result = new ArrayList<>();
  boolean[] visited = new boolean[nums.length];
  for (int size = 0; size <= nums.length; ++size) {
   backTracking(results, result, 0, size, nums, visited);
  }
  return results;
 }

 private void backTracking(List<List<Integer>> results, List<Integer> result, int start, int size, int[] nums,
   boolean[] visited) {
  if (result.size() == size) {
   results.add(new ArrayList<>(result));
   return;
  }
  for (int i = start; i < nums.length; ++i) {
   if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] != true) {
    continue;
   }
   visited[i] = true;
   result.add(nums[i]);
   backTracking(results, result, i + 1, size, nums, visited);
   visited[i] = false;
   result.remove(result.size() - 1);
  }
 }
}
// @lc code=end
// 加上重复元素的判断即可
