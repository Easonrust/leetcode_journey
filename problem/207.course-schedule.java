class Solution {
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            dfs(visited, onPath, graph, i);
        }
        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }

    private void dfs(boolean[] visited, boolean[] onPath, List<Integer>[] graph, int cur) {
        if (onPath[cur]) {
            hasCycle = true;
        }

        if (visited[cur]) {
            return;
        }

        visited[cur] = true;
        onPath[cur] = true;
        for (int next : graph[cur]) {
            dfs(visited, onPath, graph, next);
        }
        onPath[cur] = false;
    }
}