class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; ++i){
            graph[i] = new ArrayList<>();
        }
        for(int[] prerequisite:prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
            indegree[to] += 1;
        }
        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        int count = 0;
        for(int i=0; i<indegree.length; ++i){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                int cur = q.poll();
                res[count] = cur;
                count++;
                for(int next:graph[cur]){
                    indegree[next]-=1;
                    if(indegree[next]==0){
                        q.offer(next);
                    }
                }
            }
        }
        if(count!=numCourses){
            return new int[]{};
        }
        return res;
    }
}