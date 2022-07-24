class Solution {
    public int minimumKeypresses(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); ++i){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((o1,o2)->(map.get(o1)-map.get(o2)));
        
        for(char c:map.keySet()){
            pq.offer(c);
        }
        
        while(!pq.isEmpty()) {
            char c = pq.poll();
            int sz = pq.size();
            res += map.get(c) * (sz/9+1);
        }
        
        return res;
    }
}
