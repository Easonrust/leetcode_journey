class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0] = 0;
        for(int i=1; i<=n; ++i){
            preSum[i] = preSum[i-1] + nums[i-1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<=n; ++i){
            int mod = Math.floorMod(preSum[i], k);
            if(map.containsKey(mod)){
                res += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        return res;
    }
}

// 同余定理