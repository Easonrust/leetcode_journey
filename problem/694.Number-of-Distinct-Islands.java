class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 1, sb);
                    islands.add(sb.toString());
                }
            }
        }
        
        return islands.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int dir, StringBuilder sb){
        int m = grid.length;
        int n = grid[0].length;
        
        if(!(i>=0&&i<m&&j>=0&&j<n)){
            return;
        }
        
        if(grid[i][j]==0){
            return;
        }
        
        sb.append(dir);
        grid[i][j] = 0;
        
        dfs(grid, i+1, j, 1, sb);
        dfs(grid, i-1, j, 2, sb);
        dfs(grid, i, j+1, 3, sb);
        dfs(grid, i, j-1, 4, sb);
        sb.append(-dir);
    }
}