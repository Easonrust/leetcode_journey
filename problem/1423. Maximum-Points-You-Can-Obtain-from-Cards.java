class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] dp1 = new int[k+1];
        int[] dp2 = new int[k+1];
        dp1[0] = 0;
        dp2[0] = 0;
        for(int i=1; i<=k; ++i){
            dp1[i] = dp1[i-1] + cardPoints[i-1];
        }
        for(int j=1; j<=k; ++j){
            dp2[j] = dp2[j-1] + cardPoints[n-j];
        }
        int res = Integer.MIN_VALUE;
        for(int i=0; i<=k; ++i){
            res = Math.max(res, dp1[i]+dp2[k-i]);
        }
        return res;
    }
}