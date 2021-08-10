import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (68.49%)
 * Likes:    7059
 * Dislikes: 143
 * Total Accepted:    885.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTracking(results, result, visited, nums);
        return results;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> result, boolean[] visited, int[] nums) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            backTracking(results, result, visited, nums);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end
// 注意返回结果的时候返回的应该要构造一个新的result的list,其他题类似的使用StringBuilder
