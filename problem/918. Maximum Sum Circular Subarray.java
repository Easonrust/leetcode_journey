class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = 0;
        int curMax = 0;
        int curMin = 0;
        int totalMax = nums[0];
        int totalMin = nums[0];
        for(int i=0; i<n; ++i){
            curMax = Math.max(curMax+nums[i], nums[i]);
            curMin = Math.min(curMin+nums[i], nums[i]);
            totalMax = Math.max(totalMax, curMax);
            totalMin = Math.min(totalMin, curMin);
            total += nums[i];
        }
        if(totalMax<0){
            return totalMax;
        }
        return Math.max(totalMax, total-totalMin);
    }
}