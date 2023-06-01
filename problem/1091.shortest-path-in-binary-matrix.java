class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}, {1, -1}, {-1, 1}, {1, 1}, {-1, -1}};
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int n = grid.length;
        q.offer(new int[]{0,0});
        visited.add(0*n+0);
        int res = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int[] cur = q.poll();
                if(cur[0]==n-1&&cur[1]==n-1){
                    return res;
                }
                for(int[] dir:dirs){
                    int nx = cur[0]+dir[0];
                    int ny = cur[1]+dir[1];
                    if(nx>=0&&ny>=0&&nx<n&&ny<n&&!visited.contains(nx*n+ny)&&grid[nx][ny]==0){
                        q.offer(new int[]{nx, ny});
                        visited.add(nx*n+ny);
                    }
                }
            }
            res++;
        } 
        return -1;
    }
}