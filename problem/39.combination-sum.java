import java.util.ArrayList;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 *
 * https://leetcode.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (61.12%)
 * Likes:    6963
 * Dislikes: 169
 * Total Accepted:    797.3K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen
 * numbers sum to target. You may return the combinations in any order.
 * 
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen
 * numbers is different.
 * 
 * It is guaranteed that the number of unique combinations that sum up to
 * target is less than 150 combinations for the given input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple
 * times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: candidates = [2], target = 1
 * Output: []
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: candidates = [1], target = 1
 * Output: [[1]]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: candidates = [1], target = 2
 * Output: [[1,1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * All elements of candidates are distinct.
 * 1 <= target <= 500
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backTracking(results, result, candidates, 0, target);
        return results;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> result, int[] candidates, int start,
            int target) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                result.add(candidates[i]);
                backTracking(results, result, candidates, i, target - candidates[i]);
                result.remove(result.size() - 1);
            }
        }
    }
}
// @lc code=end
// 这种组合问题要想避免重复，就要增加一个start元素在backTracking里面
