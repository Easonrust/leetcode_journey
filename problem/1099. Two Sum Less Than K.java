class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        
        int lo = 0;
        int hi = nums.length - 1;
        while(lo<hi){
            int sum = nums[lo] + nums[hi];
            if(sum<k){
                res = Math.max(res, sum);
                lo++;
            }else{
                hi--;
            }
        }
        
        if(res==Integer.MIN_VALUE){
            return -1;
        }
        
        return res;
    }
}
