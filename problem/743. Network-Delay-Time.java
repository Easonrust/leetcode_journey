class Solution {
    class State {
        int id;
        int distFromStart;
        public State(int id, int distFromStart){
            this.id = id;
            this.distFromStart = distFromStart;
        }
    }
    private List<int[]>[] buildGraph(int[][] times, int n){
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=1;i<graph.length;++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] time:times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph[u].add(new int[]{v,w});
        }
        return graph;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = buildGraph(times, n);
        int[] distTo = new int[n+1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[k] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((o1,o2)->(o1.distFromStart-o2.distFromStart));
        pq.offer(new State(k,0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            if(cur.distFromStart>distTo[cur.id]){
                continue;
            }
            for(int[] edge:graph[cur.id]){
                int nextId = edge[0];
                int distToNextNode = distTo[cur.id] + edge[1];
                if(distToNextNode<distTo[nextId]){
                    distTo[nextId] = distToNextNode;
                    pq.offer(new State(nextId,distTo[nextId]));
                }
            }
        }
        
        int res = 0;
        for(int i=1;i<distTo.length;++i){
            res = Math.max(res, distTo[i]);
        }
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
}