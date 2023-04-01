class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        for(int i=1; i<n; ++i){
            dp1[i] = getMin(dp1[i-1]*nums[i], dp2[i-1]*nums[i], nums[i]);
            dp2[i] = getMax(dp1[i-1]*nums[i], dp2[i-1]*nums[i], nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for(int d:dp2){
            res = Math.max(res, d);
        }
        
        return res;
    }

    public int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int getMax(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}