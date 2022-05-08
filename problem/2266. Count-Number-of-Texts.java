class Solution {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] % mod;
            if (i > 1 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 2)) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
                if (i > 2 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 3)) {
                    dp[i] = (dp[i] + dp[i - 3]) % mod;
                    if (i > 3 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - 4)
                            && (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9')) {
                        dp[i] = (dp[i] + dp[i - 4]) % mod;
                    }
                }
            }
        }
        return dp[n];
    }
}

// dp
