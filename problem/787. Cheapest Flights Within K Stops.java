
class Solution {
    Map<Integer, List<int[]>> indegree;
    int src;
    int[][] memo;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // 中转站转换为边的个数
        k = k + 1;
        this.src = src;
        memo = new int[n][k+1];
        for(int[] m:memo){
            Arrays.fill(m, -2);
        }
        indegree = new HashMap<>();
        for(int[] flight:flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            List<int[]> list = new ArrayList<>();
            if(indegree.containsKey(to)){
                list = indegree.get(to);
            }
            list.add(new int[]{from, price});
            indegree.put(to, list);
        }
        return dp(dst, k);
    }
    
    private int dp(int dst, int k){
        if(src==dst){
            return 0;
        }
        
        if(k==0){
            return -1;
        }
        
        if(memo[dst][k]!=-2){
            return memo[dst][k];
        }
        
        int res = Integer.MAX_VALUE;
        if(!indegree.containsKey(dst)){
            memo[dst][k] = -1;
            return -1;
        }
        
        List<int[]> list = indegree.get(dst);
        for(int[] degree:list){
            int from = degree[0];
            int price = degree[1];
            int subproblem = dp(from, k-1);
            if(subproblem!=-1){
                res = Math.min(res, subproblem+price);
            }
        }
        
        if(res==Integer.MAX_VALUE){
            memo[dst][k] = -1;
            return -1;
        }
        
        memo[dst][k] = res;
        
        return res;
    }
}