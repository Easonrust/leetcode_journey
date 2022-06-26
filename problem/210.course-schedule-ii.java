class Solution {
    boolean hasCycle = false;
    boolean[] onPath;
    boolean[] visited;
    List<Integer> postOrder;
    
    List<Integer>[] buildGraph(int n, int[][] prerequisites){
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;++i){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] prerequisite:prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        postOrder = new ArrayList<>();
        for(int i=0;i<numCourses;++i){
            traverse(graph,i);
        }
        if(hasCycle){
            return new int[]{};
        }
        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for(int i=0;i<res.length;++i){
            res[i] = postOrder.get(i);
        }
        return res;
    }
    
    private void traverse(List<Integer>[] graph, int s){
        if(onPath[s]==true){
            hasCycle = true;
        }
        
        if(visited[s]||hasCycle){
            return;
        }
        
        visited[s] = true;
        onPath[s] = true;
        for(int v:graph[s]){
            traverse(graph,v);
        }
        postOrder.add(s);
        onPath[s] = false;
    }
}