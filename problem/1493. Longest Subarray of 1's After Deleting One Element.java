class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        int zeroCnt = 0;
        int oneCnt = 0;
        while(right<n){
            int in = nums[right];
            right++;
            zeroCnt += (1-in);
            oneCnt += in;
            while(zeroCnt>1){
                int out = nums[left];
                left++;
                zeroCnt -= (1-out);
                oneCnt -= out;
            }
            res = Math.max(res, oneCnt);
        }
        return res - (1 - zeroCnt);
    }
}