class Solution {
    boolean ok = true;
    boolean[] color;
    boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for(int i=0;i<n;++i){
            if(!visited[i]){
                traverse(graph, i);
            }
        }
        return ok;
    }
    
    private void traverse(int[][] graph, int s){
        if(ok==false){
            return;
        }
        
        visited[s] = true;
        for(int v:graph[s]){
            if(visited[v]==false){
                color[v] = !color[s];
                traverse(graph,v);
            }else{
                if(color[v]==color[s]){
                    ok = false;
                    return;
                }
            }
        }
    }
}