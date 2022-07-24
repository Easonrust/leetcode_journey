class Solution {
    int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int[][][] memo;
    int mod = (int)(1e9+7);
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        int res = 0;
        memo = new int[m][n][maxMove+1];
        for(int[][] mem:memo){
            for(int[] me:mem){
                Arrays.fill(me, -1);
            }
        }
        for(int i=maxMove; i<=maxMove; ++i){
            res+=dfs(startRow, startColumn, m, n, i);
        }
        return res;
    }
    
    private int dfs(int i, int j, int m, int n, int move){ 
        //不管跑完没跑完，都算进去了
        if(i<0||j<0||i>=m||j>=n){
            return 1;
        }
        
        if(move==0){
            return 0;
        }
        
        if(memo[i][j][move]!=-1){
            return memo[i][j][move];
        }
        
        int res = 0;
        
        for(int[] dir:dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            res = (res+dfs(ni, nj, m, n, move-1))%mod;
        }
        
        
        memo[i][j][move] = res;
        return res;
    }
}
