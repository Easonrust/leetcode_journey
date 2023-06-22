class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; ++i){
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = (-prices[i]-fee);
            }else{
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
                dp[i][1] = Math.max(dp[i-1][0]-prices[i]-fee, dp[i-1][1]);
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}