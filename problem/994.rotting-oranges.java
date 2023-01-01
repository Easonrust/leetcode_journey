class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] seen = new boolean[m][n];
        Set<Integer> fresh = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j]==0){
                    continue;
                }
                if(grid[i][j]==1){
                    fresh.add(n*i+j);
                }else{
                    seen[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};

        int res = 0;
        while(!q.isEmpty()){
            if(fresh.isEmpty()){
                return res;
            }
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int[] rot = q.poll();
                for(int[] dir:dirs){
                    int ni = rot[0] + dir[0];
                    int nj = rot[1] + dir[1];
                    if(ni>=0&&ni<m&&nj>=0&&nj<n&&seen[ni][nj]==false&&grid[ni][nj]==1){
                        seen[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                        fresh.remove(n*ni+nj);
                    }
                }
            }
            res++;
        }

        if(!fresh.isEmpty()){
            return -1;
        }
        return res;
    }
}