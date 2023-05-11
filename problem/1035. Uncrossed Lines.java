class Solution {
    int[][] memo;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for(int[] me:memo){
            Arrays.fill(me, -1);
        }
        int res = dp(nums1, 0, nums2, 0);
        int[][] memo1 = memo;
        return res;
    }

    private int dp(int[] nums1, int i, int[] nums2, int j) {
        if(i>=nums1.length||j>=nums2.length){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int res = 0;
        if(nums1[i]==nums2[j]){
            res = 1 + dp(nums1, i+1, nums2, j+1);
        }else{
            res = Math.max(dp(nums1, i+1, nums2, j), dp(nums1, i, nums2, j+1));
        }
        memo[i][j] = res;
        return res;
    }
}