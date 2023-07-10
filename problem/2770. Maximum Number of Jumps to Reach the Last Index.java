class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<n; ++i){
            int pre = -2;
            for(int j=0; j<i; ++j){
                if(dp[j]!=-1&&Math.abs(nums[i]-nums[j])<=target){
                    pre = Math.max(pre, dp[j]);
                }
            }
            dp[i] = pre + 1;
        }
        return dp[n-1];
    }
}