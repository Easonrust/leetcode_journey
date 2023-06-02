class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i==j){
                    continue;
                }
                if(canDetonate(bombs, i, j)){
                    graph[i].add(j);
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int res = 1;
        for(int i=0; i<n; ++i){
            q.offer(i);
            visited.add(i);
            int cnt = 1;
            while(!q.isEmpty()){
                int sz = q.size();
                for(int j=0; j<sz; ++j){
                    int cur = q.poll();
                    if(graph[cur].size()==0){
                        continue;
                    }
                    for(int neighbor:graph[cur]){
                        if(!visited.contains(neighbor)){
                            q.offer(neighbor);
                            visited.add(neighbor);
                            cnt++;
                        }
                    }
                }
            }
            res = Math.max(res, cnt);
            visited.clear();
        }
        return res;
    }

    private boolean canDetonate(int[][] bombs, int i, int j) {
        return  Math.pow(bombs[i][2], 2) >= Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2);
    }
}