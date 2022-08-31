class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        
        for(int i=0; i<m; ++i){
            dfs(i, 0, heights, canReachP);
            dfs(i, n-1, heights, canReachA);
        }
        
        for(int j=0; j<n; ++j){
            dfs(0, j, heights, canReachP);
            dfs(m-1, j, heights, canReachA);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(canReachP[i][j]&&canReachA[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int i, int j, int[][] heights, boolean[][] canReach){
        int m = canReach.length;
        int n = canReach[0].length;
        
        canReach[i][j] = true;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if(ni>=0&&ni<m&&nj>=0&&nj<n&&heights[ni][nj]>=heights[i][j]&&canReach[ni][nj]==false){
                dfs(ni, nj, heights, canReach);
            }
        }
    }
}