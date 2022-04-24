class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        dfs(0, graph, track);
        return res;
    }
    
    private void dfs(int i, int[][] graph, List<Integer> track){
        track.add(i);
        
        if(i==graph.length-1){
            res.add(new ArrayList<>(track));
        }
        
        for(int node:graph[i]){
            dfs(node, graph, track);
        }
        
        track.remove(track.size()-1);
    }
}