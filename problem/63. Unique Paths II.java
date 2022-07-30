class Solution {
    int[][] memo;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        memo = new int[m][n];
        for(int[] me:memo){
            Arrays.fill(me, -1);
        }
        return dp(obstacleGrid, m-1, n-1);
    }
    
    private int dp(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i<0||i>=m||j<0||j>=n){
            return 0;
        }
        
        if(grid[i][j]==1){
            return 0;
        }
        
        if(i==0&&j==0){
            return 1;
        }
        
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        memo[i][j] = dp(grid, i-1, j) + dp(grid, i, j-1);

        return memo[i][j];
    }
}
