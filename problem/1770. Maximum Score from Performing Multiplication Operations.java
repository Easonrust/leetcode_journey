class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
        dp[0][0] = 0;
        for(int i=1; i<=m; ++i){
            dp[i][0] = dp[i-1][0] + nums[i-1]*multipliers[i-1];
        }
        for(int j=1; j<=m; ++j){
            dp[0][j] = dp[0][j-1] + nums[n-j]*multipliers[j-1];
        }
        for(int i=1; i<=m; ++i){
            for(int j=1;(i+j)<=m; ++j){
                dp[i][j] = Math.max(dp[i-1][j]+nums[i-1]*multipliers[i+j-1], dp[i][j-1]+nums[n-j]*multipliers[i+j-1]);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i=0; i<=m; ++i){
            res = Math.max(res, dp[i][m-i]);
        }
        return res;
    }
}