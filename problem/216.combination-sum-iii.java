import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 *
 * https://leetcode.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (61.66%)
 * Likes:    2092
 * Dislikes: 68
 * Total Accepted:    243K
 * Total Submissions: 392.9K
 * Testcase Example:  '3\n7'
 *
 * Find all valid combinations of k numbers that sum up to n such that the
 * following conditions are true:
 * 
 * 
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * 
 * 
 * Return a list of all possible valid combinations. The list must not contain
 * the same combination twice, and the combinations may be returned in any
 * order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * 
 * Example 2:
 * 
 * 
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is
 * 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: k = 3, n = 2
 * Output: []
 * Explanation: There are no valid combinations.
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: k = 9, n = 45
 * Output: [[1,2,3,4,5,6,7,8,9]]
 * Explanation:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
 * There are no other valid combinations.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= k <= 9
 * 1 <= n <= 60
 * 
 * 
 */

// @lc code=start
class Solution {
 public List<List<Integer>> combinationSum3(int k, int n) {
  List<List<Integer>> results = new ArrayList<>();
  List<Integer> result = new ArrayList<>();
  backTracking(results, result, 1, n, k);
  return results;
 }

 private void backTracking(List<List<Integer>> results, List<Integer> result, int start, int n, int k) {
  if (k == 0 || n == 0) {
   if (k == 0 && n == 0) {
    results.add(new ArrayList<>(result));
   }
   return;
  }
  for (int i = start; i <= 9 - k + 1; ++i) {
   result.add(i);
   backTracking(results, result, i + 1, n - i, k - 1);
   result.remove(result.size() - 1);
  }
 }
}
// @lc code=end
// 加入9-k+1的剪枝可以更快
