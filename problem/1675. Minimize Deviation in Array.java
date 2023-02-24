class Solution {
    public int minimumDeviation(int[] nums) {
        int res = Integer.MAX_VALUE;
        int curMin = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->(o2-o1));
        for(int num:nums){
            if(num%2!=0){
                num = num*2;
            }
            pq.offer(num);
            curMin = Math.min(curMin, num);
        }
        while(!pq.isEmpty()){
            int cur = pq.poll();
            res = Math.min(res, cur-curMin);
            if(cur%2!=0){
                break;
            }
            cur = cur/2;
            curMin = Math.min(curMin, cur);
            pq.offer(cur);
        }
        return res;
    }
}