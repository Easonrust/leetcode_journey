class Solution {
    Map<Integer, List<Integer>> graph;
    boolean[] visited;
    int[] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new HashMap<>();
        visited = new boolean[n];
        for(int[] edge:edges){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }
        res = new int[n];
        dfs(0, labels);
        return res;
    }

    private int[] dfs(int node, String labels) {
        int[] curCnts = new int[26];
        curCnts[labels.charAt(node)-'a']++;
        visited[node] = true;
        for(int child:graph.get(node)) {
            if(visited[child]){
                continue;
            }
            int[] childCnts = dfs(child, labels);
            for(int i=0; i<26; ++i){
                curCnts[i] += childCnts[i];
            }
        }
        res[node] = curCnts[labels.charAt(node)-'a'];
        return curCnts;
    }
}