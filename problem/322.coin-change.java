class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }
    
    public int dp(int[] coins, int amount){
        if(amount==0){
            return 0;
        }
        
        if(amount<0){
            return -1;
        }
        
        if(memo[amount]!=-2){
            return memo[amount];
        }
        
        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int sub = dp(coins, amount-coin);
            if(sub!=-1){
                res = Math.min(res, sub+1);
            }
        }
        
        if(res==Integer.MAX_VALUE){
            memo[amount] = -1;
            return -1;
        }
        
        memo[amount] = res;
        
        return res;
    }
}