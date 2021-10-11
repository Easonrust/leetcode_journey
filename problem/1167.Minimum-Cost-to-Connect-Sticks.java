class Solution {
    public int connectSticks(int[] sticks) {
        int totalCost=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int stick:sticks){
            pq.add(stick);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            int sum=first+second;
            totalCost+=sum;
            pq.add(sum);
        }
        return totalCost;
    }
}

// Apply min heap to solve the problem, always select the smallest and second smallest sticks