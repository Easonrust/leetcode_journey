import java.util.ArrayList;
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
