class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->(o1[0]-o2[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int idx = 0;
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; ++i){
            if(end<intervals[i][0]){
                end = intervals[i][1];
                list.add(intervals[i]);
                idx++;
            }else{
                if(end<intervals[i][1]){
                    end = intervals[i][1];
                    int[] temp = list.get(idx);
                    list.set(idx, new int[]{temp[0], end});
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i=0; i<list.size(); ++i){
            res[i] = list.get(i);
        }

        return res;
    }
}