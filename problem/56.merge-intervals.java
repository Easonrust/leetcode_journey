/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
 public int[][] merge(int[][] intervals) {
  Arrays.sort(intervals, new Comparator<>() {
   public int compare(int[] o1, int[] o2) {
    return o1[0] - o2[0];
   }
  });
  List<int[]> res = new ArrayList<>();
  int end = intervals[0][1];
  int index = 0;
  res.add(intervals[0]);
  for (int i = 1; i < intervals.length; ++i) {
   if (end >= intervals[i][0]) {
    // overlapping
    end = Math.max(end, intervals[i][1]);
    int[] temp = res.get(index);
    res.set(index, new int[] { temp[0], end });
   } else {
    index++;
    res.add(intervals[i]);
    end = intervals[i][1];
   }
  }
  int[][] resArr = new int[res.size()][2];
  for (int i = 0; i < res.size(); ++i) {
   resArr[i] = res.get(i);
  }
  return resArr;
 }
}
// @lc code=end
