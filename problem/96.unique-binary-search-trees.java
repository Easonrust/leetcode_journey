class Solution {
    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n+1][n+1];
        return build(1,n);
    }
    
    public int build(int lo, int hi){
        if(lo>hi){
            return 1;
        }
        
        if(memo[lo][hi]!=0){
            return memo[lo][hi];
        }
        
        int res = 0;
        for(int i=lo;i<=hi;++i){
            int left = build(lo, i-1);
            int right = build(i+1, hi);
            res += left*right;
        }
        memo[lo][hi] = res;
        return res;
    }
}