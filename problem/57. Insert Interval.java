class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        for(int i=0; i<intervals.length; ++i){
            int[] interval = intervals[i];
            if(interval[0]>right){
                if(!placed){
                    list.add(new int[]{left, right});
                    placed = true;
                }
                list.add(interval);
            }else if (interval[1]<left){
                list.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if(!placed){
            list.add(new int[]{left, right});
        }

        int[][] res = new int[list.size()][2];
        for(int i=0; i<res.length; ++i){
            res[i] = list.get(i);
        }

        return res;
    }
}