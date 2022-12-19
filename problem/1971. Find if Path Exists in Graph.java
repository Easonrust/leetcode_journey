class Solution {
    boolean[] used;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        used = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            List<Integer> list = new ArrayList<>();
            if(graph.containsKey(edge[0])){
                list = graph.get(edge[0]);
            }
            list.add(edge[1]);
            graph.put(edge[0], list);
        }
        for(int[] edge:edges){
            List<Integer> list = new ArrayList<>();
            if(graph.containsKey(edge[1])){
                list = graph.get(edge[1]);
            }
            list.add(edge[0]);
            graph.put(edge[1], list);
        }
        return dfs(graph, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, int destination) {
        if(cur==destination){
            return true;
        }
        if(used[cur]){
            return false;
        }
        used[cur] = true;
        for(int next:graph.get(cur)){
            if(dfs(graph, next, destination)){
                return true;
            }
        }
        return false;
    }
}
