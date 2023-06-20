class Solution {
    public int[] getAverages(int[] nums, int k) {
        long[] preSum = new long[nums.length+1];
        for(int i=1; i<=nums.length; ++i){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int[] avgs = new int[nums.length];
        Arrays.fill(avgs, -1);
        int len = 2*k+1;
        for(int i=k; i<Math.min(nums.length, nums.length-k); i++){
            avgs[i] = (int)((preSum[i+k+1]-preSum[i-k])/len);
        } 
        return avgs;
    }
}