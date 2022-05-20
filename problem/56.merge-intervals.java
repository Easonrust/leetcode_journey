class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        list.add(intervals[0]);
        int end = intervals[0][1];
        int idx = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (end < intervals[i][0]) {
                idx++;
                end = intervals[i][1];
                list.add(intervals[i]);
            } else {
                if (end < intervals[i][1]) {
                    end = intervals[i][1];
                    int[] temp = list.get(idx);
                    list.set(idx, new int[] { temp[0], end });
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; ++i) {
            res[i] = list.get(i);
        }

        return res;
    }
}