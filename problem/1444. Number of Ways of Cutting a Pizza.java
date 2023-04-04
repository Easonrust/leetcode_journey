class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = 1000000000 + 7;
        int[][][] dp = new int[m][n][k+1];
        int[][] preSum = new int[m+1][n+1];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(pizza[i].charAt(j)=='A'){
                    preSum[i][j] = 1;
                }
                preSum[i][j] += preSum[i+1][j] + preSum[i][j+1] - preSum[i+1][j+1]; 
            }
        }
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(preSum[i][j]>0){
                    dp[i][j][1] = 1;
                }
                for(int p=2; p<=k; ++p){
                    for(int x=m-1-i; x>=1; x--){
                        if(preSum[i][j]-preSum[i+x][j]>0){
                            dp[i][j][p] += (dp[i+x][j][p-1]);
                            dp[i][j][p]%=mod;
                        }
                    }
                }
                for(int p=2; p<=k; ++p){
                    for(int y=n-1-j; y>=1; y--){
                        if(preSum[i][j]-preSum[i][j+y]>0){
                            dp[i][j][p] += (dp[i][j+y][p-1]);
                            dp[i][j][p]%=mod;
                        }
                    }
                }
            }
        }
        return dp[0][0][k];
    }
}