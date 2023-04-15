class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; ++i){
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite:prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; ++i){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int cur = q.poll();
                cnt++;
                for(int next:graph[cur]){
                    indegree[next]--;
                    if(indegree[next]==0){
                        q.offer(next);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}