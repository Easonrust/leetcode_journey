class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int res = -1;
        int min = Integer.MAX_VALUE;
        int[] dist1 = getDist(edges, node1);
        int[] dist2 = getDist(edges, node2);
        for(int i=0; i<n; ++i){
            if(dist1[i]==-1||dist2[i]==-1){
                continue;
            }
            int max = Math.max(dist1[i], dist2[i]);
            if(max<min){
                min = max;
                res = i;
            }
        }
        return res;
    }

    private int[] getDist(int[] edges, int node) {
        int n = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        int d = 0;
        while(node!=-1){
            if(dist[node]!=-1){
                break;
            }
            dist[node] = d++;
            node = edges[node];
        }
        return dist;
    }
}