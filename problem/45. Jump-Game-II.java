class Solution {
    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int p) {
        int n = nums.length;
        if (p >= n - 1) {
            return 0;
        }

        if (memo[p] != n) {
            return memo[p];
        }

        int steps = nums[p];
        for (int i = 1; i <= steps; ++i) {
            memo[p] = Math.min(memo[p], dp(nums, p + i) + 1);
        }

        return memo[p];
    }
}
