class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i=1; i<=nums.length; ++i){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<preSum.length; ++i){
            int mod = Math.floorMod(preSum[i], k);
            if(map.containsKey(mod)){
                res += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod,0)+1);
        }
        
        return res;
    }
}
