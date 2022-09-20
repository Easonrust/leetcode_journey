class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        dp[m][n] = 0;
        int res = 0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(nums1[i]==nums2[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}