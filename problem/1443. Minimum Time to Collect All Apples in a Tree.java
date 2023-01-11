class Solution {
    Map<Integer, List<Integer>> graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new HashMap<>();
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, key -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, key -> new ArrayList<>()).add(a);
        }
        return dfs(0, 0, hasApple);
    }

    private int dfs(int node, int parent, List<Boolean> hasApple) {
        if(!graph.containsKey(node)){
            return 0;
        }
        int totalTime = 0;
        int childTime = 0;
        for(int child:graph.get(node)){
            if(child==parent){
                continue;
            }
            childTime = dfs(child, node, hasApple);
            if(childTime>0 || hasApple.get(child)){
                totalTime += (childTime + 2);
            }
        }
        return totalTime;
    }
}