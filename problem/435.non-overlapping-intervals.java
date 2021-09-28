import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 *
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */

// @lc code=start
class Solution {
 public int eraseOverlapIntervals(int[][] intervals) {
  Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
  int cnt = 1;
  int end = intervals[0][1];
  for (int i = 1; i < intervals.length; ++i) {
   if (intervals[i][0] < end) {
    continue;
   }
   end = intervals[i][1];
   cnt++;
  }
  return intervals.length - cnt;
 }
}
// @lc code=end
// 注意java lambda表达式的使用
// 计算能组成的最对的不重叠区间的个数，然后拿总个数做减法，就是需要移除的区间的个数
// 做选择时使用贪心算法，选择的区间结尾越小，留给后面区间的空间越大，所以先要根据结尾对所有区间进行排序
