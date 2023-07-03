class Solution {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        int left = 0;
        int right = 0;
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while(right<n){
            int in = nums[right];
            right++;
            map.put(in, map.getOrDefault(in, 0)+1);
            
            while(map.lastKey()-map.firstKey()>2){
                int out = nums[left];
                left++;
                map.put(out, map.get(out)-1);
                if(map.get(out)==0){
                    map.remove(out);
                }
            }
            res += (long)(right-left);
        }
        return res;
    }
    
}