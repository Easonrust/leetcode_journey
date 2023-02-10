class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j){
                if(grid[i][j]==1){
                    q.offer(new int[]{i, j});
                }
            }
        }
        if(q.size()==m*n||q.size()==0){
            return -1;
        }
        int res = 0;
        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; i++){
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for(int[] dir:dirs){
                    int nx = x+dir[0];
                    int ny = y+dir[1];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&grid[nx][ny]==0){
                        grid[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            res++;
        }
        return res-1;
    }
}