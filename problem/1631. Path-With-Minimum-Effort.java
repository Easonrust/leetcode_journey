class Solution {
    class State {
        int x;
        int y;
        int effortFromStart;
        public State(int x, int y, int effortFromStart){
            this.x = x;
            this.y = y;
            this.effortFromStart = effortFromStart;
        }
    }
        
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effortTo = new int[m][n];
        for(int i=0;i<m;++i){
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        PriorityQueue<State> pq = new PriorityQueue<>((o1,o2)->(o1.effortFromStart-o2.effortFromStart));
        effortTo[0][0] = 0;
        pq.offer(new State(0,0,0));
        while(!pq.isEmpty()){
            State curState = pq.poll();
            int x = curState.x;
            int y = curState.y;
            int effortFromStart = curState.effortFromStart;
            if(x==m-1&&y==n-1){
                return effortTo[x][y];
            }
            
            if(effortFromStart>effortTo[x][y]){
                continue;
            }
            
            for(int[] next:getNext(x,y,m,n)){
                int nx = next[0];
                int ny = next[1];
                int effortToNext = Math.max(effortTo[x][y], Math.abs(heights[x][y]-heights[nx][ny]));
                if(effortToNext<effortTo[nx][ny]){
                    effortTo[nx][ny] = effortToNext;
                    pq.offer(new State(nx,ny,effortTo[nx][ny]));
                }
            }
        }
        return -1;
    }
    
    private List<int[]> getNext(int x, int y, int m, int n){
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        List<int[]> res = new ArrayList<>();
        for(int[] dir:dirs){
            int nx = x+dir[0];
            int ny = y+dir[1];
            if(nx>=0&&nx<m&&ny>=0&&ny<n){
                res.add(new int[]{nx,ny});
            }
        }
        return res;
    }
}
