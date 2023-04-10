class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] startState = {0, 0, k};
        q.offer(startState);
        int res = 0;
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][k] = true;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int[] state = q.poll();
                int x = state[0];
                int y = state[1];
                int remains = state[2];
                if(x==m-1&&y==n-1){
                    return res;
                }
                for(int[] dir:dirs){
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if(nx<0||ny<0||nx>=m||ny>=n){
                        continue;
                    }
                    if(grid[nx][ny]==1){
                        if(remains>0){
                            if(visited[nx][ny][remains-1]){
                                continue;
                            }
                            visited[nx][ny][remains-1] = true;
                            q.offer(new int[]{nx, ny, remains-1});
                        }
                    }else{
                        if(visited[nx][ny][remains]){
                            continue;
                        }
                        visited[nx][ny][remains] = true;
                        q.offer(new int[]{nx, ny, remains});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}