class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        boolean[] visited = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        Set<Integer>[] routesSet = new HashSet[routes.length];
        for(int i=0; i<routes.length; ++i){
            routesSet[i] = new HashSet<>();
            for(int stop:routes[i]){
                routesSet[i].add(stop);
            }
        }
        for(int i=0; i<routesSet.length; ++i){
            if(routesSet[i].contains(source)){
                q.offer(i);
                visited[i] = true;
            }
        }
        int cnt = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int idx = q.poll();
                if(routesSet[idx].contains(target)){
                    return cnt;
                }
                for(int stop:routesSet[idx]){
                    for(int j=0; j<routes.length; ++j){
                        if(visited[j]==false&&routesSet[j].contains(stop)){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}