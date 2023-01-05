class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] mem:memo){
            Arrays.fill(mem, -1);
        }

        return dp(m-1, n-1);
    }

    private int dp(int i, int j) {
        if(i==0&&j==0){
            return 1;
        }

        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        int res = 0;
        if(i>0){
            res += dp(i-1, j);
        }

        if(j>0){
            res += dp(i, j-1);
        }
        memo[i][j] = res;

        return res;
    }
}