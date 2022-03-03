import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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