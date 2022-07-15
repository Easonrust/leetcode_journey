class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1){
                    res= Math.max(res, dfs(i, j, grid));
                }
            }
        }
        return res;
    }
    
    private int dfs(int i, int j, int[][] grid){
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||j<0||i>=m||j>=n){
            return 0;
        }
        
        if(grid[i][j]==0){
            return 0;
        }
        
        int res = 1;
        grid[i][j] = 0;
        
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            res+=dfs(ni, nj, grid);
        }
        
        return res;
    }
}