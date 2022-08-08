class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        for(int i=1; i<=nums.length; ++i){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        
        int res = Integer.MAX_VALUE;
        for(int i=0; i<preSum.length; ++i){
            int maxIdx = binarySearch(0, i-1, preSum, preSum[i]-target);
            if(maxIdx!=-1){ 
                res = Math.min(res, i-maxIdx);
            }
        }
        
        if(res == Integer.MAX_VALUE){
            return 0;
        }
        
        return res;
    }
    
    private int binarySearch(int lo, int hi, int[] preSum, int target) {
        while(lo<=hi){
            int mid = hi + (lo-hi)/2;
            int sum = preSum[mid];
            if(sum>target){
                hi = mid-1;
            }else if(sum<target){
                lo = mid+1;
            }else{
                lo = mid+1;
            }
        }
        
        return hi;
    }
}