class Solution {
    int[][] dirs = {{-1,1},{0,1},{1,1}};
    int[][] memo;
    public int maxMoves(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for(int[] mem:memo){
            Arrays.fill(mem, -1);
        }
        for(int i=0; i<m; ++i){
            int cnt = dp(i,0,grid);
            res = Math.max(res, cnt);
        }
        return res;
    }
    
    private int dp(int i, int j, int[][] grid){
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for(int[] dir:dirs){
            int ni = i+dir[0];
            int nj = j+dir[1];
            if((ni>=0&&ni<m&&nj>=0&&nj<n)&&grid[ni][nj]>grid[i][j]){
                cnt = Math.max(cnt, 1+dp(ni,nj,grid));
            }
        }
        memo[i][j] = cnt;
        return cnt;
    }
}