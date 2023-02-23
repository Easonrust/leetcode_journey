class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] graph = new ArrayList[2][n];
        for(int i=0; i<2; ++i){
            for(int j=0; j<n; ++j){
                graph[i][j] = new ArrayList<>();
            }
        }
        for(int[] edge:redEdges){
            graph[0][edge[0]].add(edge[1]);
        }
        for(int[] edge:blueEdges){
            graph[1][edge[0]].add(edge[1]);
        }
        int[][] dist = new int[n][2];
        for(int[] dis:dist){
            Arrays.fill(dis, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        dist[0][1] = 0;
        Queue<int[]> prePath = new LinkedList<>();
        prePath.offer(new int[]{0, 1});
        prePath.offer(new int[]{0, 0});
        while(!prePath.isEmpty()){
            int[] cur = prePath.poll();
            int node = cur[0];
            int preColor = cur[1];
            for(int child:graph[1-preColor][node]){
                if(dist[child][1-preColor]==Integer.MAX_VALUE){
                    dist[child][1-preColor] = dist[node][preColor] + 1;
                    prePath.offer(new int[]{child, 1-preColor});
                }
            }
        }
        int[] res = new int[n];
        for(int i=0; i<n; ++i){
            res[i] = Math.min(dist[i][0], dist[i][1]);
            if(res[i]==Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res;
    }
}