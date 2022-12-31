class Solution {
    boolean hasCycle;
    boolean[] visited;
    boolean[] onPath;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        hasCycle = false;
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i=0; i<numCourses; ++i){
            traverse(graph, i);
        }
        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; ++i){
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite:prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int s) {
        if(onPath[s]){
            hasCycle = true;
            return;
        }

        if(visited[s]||hasCycle){
            return;
        }

        visited[s] = true;
        onPath[s] = true;
        for(int neighbor:graph[s]){
            traverse(graph, neighbor);
        }
        onPath[s] = false;
    }
}