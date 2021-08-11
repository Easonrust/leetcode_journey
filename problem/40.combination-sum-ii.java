import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (51.20%)
 * Likes:    3345
 * Dislikes: 95
 * Total Accepted:    439.9K
 * Total Submissions: 858.7K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: 
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        backTracking(results, result, 0, visited, target, candidates);
        return results;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> result, int start, boolean[] visited,
            int target, int[] candidates) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (i != 0 && candidates[i] == candidates[i - 1] && visited[i - 1] != true) {
                continue;
            }
            if (candidates[i] <= target) {
                visited[i] = true;
                result.add(candidates[i]);
                backTracking(results, result, i + 1, visited, target - candidates[i], candidates);
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}
// @lc code=end
// 不重复使用元素体现在backTracking的i+1上