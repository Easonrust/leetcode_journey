class Solution {
    boolean[] color;
    boolean[] visited;
    boolean flag;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for(int i=0; i<n; ++i){
            if(visited[i]){
                continue;
            }
            dfs(i, graph);
        }
        return !flag;
    }

    private void dfs(int i, int[][] graph) {
        if(flag){
            return;
        }

        visited[i] = true;
        for(int node:graph[i]){
            if(!visited[node]){
                color[node] = !color[i];
                dfs(node, graph);
            }else{
                if(color[node]==color[i]){
                    flag = true;
                    return;
                }
            }
        }
    }
}