class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->(map.get(o2)-map.get(o1)));
        for(int num:map.keySet()){
            pq.offer(num);
        }
        int s = k;
        int[] res = new int[s];
        while(k!=0) {
            res[s-k] = pq.poll();
            k--;
        }
        return res;
    }
}