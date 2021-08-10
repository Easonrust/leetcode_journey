import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode.com/problems/combinations/description/
 *
 * algorithms
 * Medium (59.40%)
 * Likes:    2663
 * Dislikes: 91
 * Total Accepted:    394.1K
 * Total Submissions: 660.7K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * out of the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        backTracking(results, result, 1, n, k);
        return results;
    }

    private void backTracking(List<List<Integer>> results, List<Integer> result, int start, int n, int k) {
        if (k == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i <= n - k + 1; ++i) {
            result.add(i);
            backTracking(results, result, i + 1, n, k - 1);
            result.remove(result.size() - 1);
        }
    }

}
// @lc code=end
// 使用排列的方法会出现超时的问题
