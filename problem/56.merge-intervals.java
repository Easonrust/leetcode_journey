/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
 public int[][] merge(int[][] intervals) {

  // 注意和贪心找最多不重叠区间的个数不同，这里是按照start排序，因为我们这里不是要尽可能给后面的区间留出空间，而是要合并区间
  Arrays.sort(intervals, new Comparator<>() {
   public int compare(int[] o1, int[] o2) {
    return o1[0] - o2[0];
   }
  });
  List<int[]> res = new ArrayList<>();
  int end = intervals[0][1];

  // 便于我们追踪到当前list里面的区间
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
  return res.toArray(new int[res.size()][]);
 }
}
// @lc code=end
