class Solution {
 public boolean canAttendMeetings(int[][] intervals) {
  if (intervals.length == 0) {
   return true;
  }
  Arrays.sort(intervals, new Comparator<>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    return o1[1] - o2[1];
   }
  });
  int end = intervals[0][1];
  for (int i = 1; i < intervals.length; ++i) {
   if (end > intervals[i][0]) {
    return false;
   }
   end = intervals[i][1];
  }

  return true;
 }
}

// greedy