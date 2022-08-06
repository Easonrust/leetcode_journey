class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组大小为 amount + 1，初始值也为 amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        for(int j = 0; j<coins.length; ++j) {
            for (int i = 0; i < dp.length; i++) {
                if (i - coins[j] < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}