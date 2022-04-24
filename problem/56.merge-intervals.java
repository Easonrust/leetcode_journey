class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int end = intervals[0][1];
        int idx = 0;
        list.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < intervals.length; ++i) {
            if (end >= intervals[i][0]) {
                // overlapping;
                int[] temp = list.get(idx);
                if (temp[1] < intervals[i][1]) {
                    end = intervals[i][1];
                    list.set(idx, new int[] { temp[0], end });
                }
            } else {
                idx++;
                list.add(intervals[i]);
                end = intervals[i][1];
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            int[] temp = list.get(i);
            res[i][0] = temp[0];
            res[i][1] = temp[1];
        }
        return res;
    }
}
