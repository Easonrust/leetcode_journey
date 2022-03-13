class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        long res = 0;
        for (int j = 0; j < n; ++j) {
            dp[0][j] = points[0][j];
            res = Math.max(res, dp[0][j]);
        }

        for (int i = 1; i < m; ++i) {
            long[] prefix = new long[n];
            long[] suffix = new long[n];

            prefix[0] = dp[i - 1][0] + 0;
            for (int j = 1; j < n; ++j) {
                prefix[j] = Math.max(prefix[j - 1], dp[i - 1][j] + j);
            }

            suffix[n - 1] = dp[i - 1][n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; --j) {
                suffix[j] = Math.max(suffix[j + 1], dp[i - 1][j] - j);
            }

            for (int j = 0; j < n; ++j) {
                dp[i][j] = points[i][j] + Math.max(prefix[j] - j, suffix[j] + j);
                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}

// dp, 注意用prefix和suffix降低时间复杂度
