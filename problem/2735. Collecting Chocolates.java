class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        long[] sum = new long[n];
        for(int i=0; i<n; ++i){
            sum[i] = (long)i*x;
        }

        for(int i=0; i<n; ++i){
            int minCost = nums[i];
            for(int j=0; j<n; ++j){
                minCost = Math.min(minCost, nums[(i+j)%n]);
                sum[j] += minCost;
            }
        }

        long res = Long.MAX_VALUE;
        for(long su:sum){
            res = Math.min(res, su);
        }
        return res;
    }
}