import java.util.Arrays;
// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == true) {
                continue;
            }
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
// 对于含有重复的排列，就先对原数组进行排序，然后相同的相邻元素，如果之前的已经被访问过了，就不再访问第二次
