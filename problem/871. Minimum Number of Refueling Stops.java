class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int prev = 0;
        int ans = 0;
        int fuel = startFuel;
        for(int i=0; i<=n; ++i){
            int cur = i<n ? stations[i][0] : target;
            
            fuel -= (cur-prev);
            while(fuel<0&&!pq.isEmpty()){
                fuel += (pq.poll());
                ans++;
            }
            
            if(fuel<0){
                return -1;
            }
            
            if(i<n){
                pq.offer(stations[i][1]);
                prev = cur;
            }
        }
        
        return ans;
    }
}