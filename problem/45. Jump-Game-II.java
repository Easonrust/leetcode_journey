class Solution {
    int[] memo;
    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        int n = nums.length;
        if(start>=n-1) {
            return 0;
        }

        if(memo[start]!=n){
            return memo[start];
        }

        for(int i=1; i<=nums[start]; ++i){
            memo[start] = Math.min(memo[start], dp(nums, start+i)+1);
        }
        return memo[start];
    }
}



// dp(nums, 0) 从0到终点需要的步数