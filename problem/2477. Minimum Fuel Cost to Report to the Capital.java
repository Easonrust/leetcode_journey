class Solution {
    long res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] road:roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        dfs(0, -1, graph, seats);
        return res;
    }

    private int dfs(int cur, int father, List<Integer>[] graph, int seats) {
        int size = 1;
        for(Integer child:graph[cur]){
            if(child!=father){
                size += dfs(child, cur, graph, seats);
            }
        }
        if(cur!=0){
            res += Math.ceil((double)size/(double)seats);
        }
        return size;
    }
}