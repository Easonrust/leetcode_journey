class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(mat[i][j]==0){
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                    seen[i][j] = true;
                }
            }
        } 

        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int[] cur = q.poll();
                for(int[] dir:dirs){
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni>=0&&ni<m&&nj>=0&&nj<n&&seen[ni][nj]==false){
                        dist[ni][nj] = dist[cur[0]][cur[1]] + 1;
                        seen[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }
        return dist;
    }
}