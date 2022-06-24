class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(graph, 0, path);
        return res;
    }
    
    private void traverse(int[][] graph, int s, List<Integer> path){
        path.add(s);
        if(s==graph.length-1){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        
        for(int v:graph[s]){
            traverse(graph, v, path);
        }
        
        path.remove(path.size()-1);
    }
}