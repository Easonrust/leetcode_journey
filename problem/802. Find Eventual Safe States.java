class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] reversedGraph = new ArrayList[n];
        for(int i=0; i<n; ++i){
            reversedGraph[i] = new ArrayList<>();
        }

        for(int i=0; i<n; ++i){
            for(int node:graph[i]){
                reversedGraph[node].add(i);
            }
        }

        int[] indegree = new int[n];
        for(int i=0; i<n; ++i){
            indegree[i] = graph[i].length;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; ++i){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int cur = q.poll();
                for(int next:reversedGraph[cur]){
                    indegree[next]--;
                    if(indegree[next]==0){
                        q.offer(next);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n; ++i){
            if(indegree[i]==0){
                res.add(i);
            }
        }

        return res;
    }
}