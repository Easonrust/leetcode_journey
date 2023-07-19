class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (o1, o2)->(o1[1]-o2[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for(int i=1; i<n; ++i){
            int[] interval = intervals[i];
            if(interval[0]<end){
                continue;
            }
            cnt++;
            end = interval[1];
        }
        return n-cnt;
    }
}