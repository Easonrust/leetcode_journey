class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]+a[1])-(b[0]+b[1])));
        for(int i=0; i<nums1.length; ++i){
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while(!pq.isEmpty()&&k>0){
            int[] cur = pq.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
            if(cur[2]<nums2.length-1){
                pq.offer(new int[]{cur[0], nums2[cur[2]+1], cur[2]+1});
            }
            k--;
        }
        return res;
    }
}