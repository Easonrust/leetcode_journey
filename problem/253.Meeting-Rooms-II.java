class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] begin = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; ++i) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int res = 0;
        int count = 0;
        while (i < n && j < n) {
            if (begin[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }

        return res;
    }
}