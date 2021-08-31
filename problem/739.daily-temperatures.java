import java.util.Stack;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (65.48%)
 * Likes:    4920
 * Dislikes: 139
 * Total Accepted:    278.4K
 * Total Submissions: 423.4K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the i^th day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
 public int[] dailyTemperatures(int[] temperatures) {
  int n = temperatures.length;
  int[] dist = new int[n];
  Stack<Integer> indexs = new Stack<>();
  for (int curIdx = 0; curIdx < n; ++curIdx) {

   // 注意这里是while，因为终于出现了一个大于前面元素的树，前面所有符合条件元素的dist都要一起计算
   while (!indexs.isEmpty() && temperatures[curIdx] > temperatures[indexs.peek()]) {
    int preIdx = indexs.pop();
    dist[preIdx] = curIdx - preIdx;
   }
   indexs.add(curIdx);
  }
  return dist;
 }
}
// @lc code=end
