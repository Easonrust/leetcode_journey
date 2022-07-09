class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for(int[] e:memo){
            Arrays.fill(e, -1);
        }
        int res = Integer.MAX_VALUE;
        for(int j=0; j<n; ++j){
            res = Math.min(res, dp(n-1, j, matrix));
        }
        
        return res;
    }
    
    private int dp(int i, int j, int[][] matrix){
        if(i==0){
            return matrix[i][j];
        }
        
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        int top = dp(i-1, j, matrix);
        int topLeft = j==0 ? Integer.MAX_VALUE : dp(i-1, j-1, matrix);
        int topRight = j==(matrix[0].length-1) ? Integer.MAX_VALUE : dp(i-1, j+1, matrix);
        
        int res = Integer.MAX_VALUE;
        res = Math.min(top, Math.min(topLeft, topRight)) + matrix[i][j];
        
        memo[i][j] = res;
        
        return res;
    }
}
