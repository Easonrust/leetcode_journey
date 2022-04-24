class Solution {
    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {

        if (start >= nums.length - 1) {
            return 0;
        }
        if (memo[start] != nums.length) {
            return memo[start];
        }

        for (int i = 1; i <= nums[start]; ++i) {
            int subProblem = dp(nums, start + i);
            memo[start] = Math.min(memo[start], subProblem + 1);
        }
        return memo[start];
    }
}
