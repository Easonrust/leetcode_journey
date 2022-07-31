class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int[] d:dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<m; ++i){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j=1; j<triangle.get(i).size(); ++j){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int e:dp[m-1]){
            res = Math.min(res, e);
        }
        
        return res;
    }
}