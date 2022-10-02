class Solution {
    int[][] memo;
    int mod = (int)(1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        memo = new int[n+1][target+1];
        for(int[] me:memo){
            Arrays.fill(me, -1);
        }
        return dp(n, k, target);
    }
    
    private int dp(int n, int k, int target) {
        if(n==0||target>n*k||target<n){
            return 0;
        }
        
        if(n==1&&target<=k&&target>=1){
            return 1;
        }
        
        if(memo[n][target]!=-1){
            return memo[n][target];
        }
        
        int res = 0;
        for(int i=1; i<=k; ++i){
            res = (res + dp(n-1, k, target-i))%mod; 
        }
        memo[n][target] = res;
        return res;
    }
}