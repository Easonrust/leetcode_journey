class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0];
            }
        });
        
        // Mean Heap
        PriorityQueue<Integer> allocator=new PriorityQueue<>();
        
        allocator.add(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            
            // if some room is free
            if(intervals[i][0]>=allocator.peek()){
                allocator.poll();
            }
            
            allocator.add(intervals[i][1]);
        }
        return allocator.size();

    }
}