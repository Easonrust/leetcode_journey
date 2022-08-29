class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        
        if(i<0||i>=m||j<0||j>=n){
            return;
        }
        
        if(grid[i][j]=='0'){
            return;
        }
        grid[i][j] = '0';
        
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] dir:dirs){
            dfs(grid, i+dir[0], j+dir[1]);
        }
    }
}