class Solution {
    int[][] memo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        memo = new int[m][n];
        for(int i=0; i<m; ++i){
            Arrays.fill(memo[i], -1);
        }
        
        return dp(dungeon, 0, 0);
    }
    
    private int dp(int[][] dungeon, int i, int j){
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        if(i==m-1&&j==n-1){
            return dungeon[i][j]>=0 ? 1 : 1-dungeon[i][j];
        }
        
        if (i == m || j == n) {
            return Integer.MAX_VALUE;
        }
        
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        
        int res = Math.min(dp(dungeon, i, j+1), dp(dungeon, i+1, j)) - dungeon[i][j];
        
        memo[i][j] = res <= 0 ? 1 : res;
        return memo[i][j];
    }
}

// dp(grid, i, j) 从i，j到右下角所需要的最小步数
