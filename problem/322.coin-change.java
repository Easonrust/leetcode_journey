class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo, 666);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if(amount==0){
            return 0;
        }

        if(amount<0){
            return -1;
        }

        if(memo[amount]!=666){
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for(int coin:coins){
            int next = dp(coins, amount-coin);
            if(next==-1){
                continue;
            }
            res = Math.min(res, next+1);
        }
        if(res==Integer.MAX_VALUE){
            memo[amount] = -1;
        }else{
            memo[amount] = res;
        }
        return memo[amount];
    }
}