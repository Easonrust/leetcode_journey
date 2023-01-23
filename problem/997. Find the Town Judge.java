class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for(int i=0; i<trust.length; ++i){
            int from = trust[i][0];
            int to = trust[i][1];
            indegree[to-1]++;
            outdegree[from-1]++;
        }

        for(int i=0; i<n; ++i){
            if(indegree[i]==n-1&&outdegree[i]==0){
                return i+1;
            }
        }
        return -1;
    }
}