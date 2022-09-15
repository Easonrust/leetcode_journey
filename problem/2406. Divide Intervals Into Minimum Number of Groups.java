class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->(o1[0]-o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i=1; i<intervals.length; ++i){
            if(intervals[i][0]>pq.peek()){
                pq.poll();
            }
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }
}

// meeting rooms 2 