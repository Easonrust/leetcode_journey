class Solution {
    public boolean checkArray(int[] nums, int k) {
        int cur = 0;
        for(int i=0; i<nums.length; ++i){
            if(cur>nums[i]){
                return false;
            }
            nums[i] -= cur;
            cur += nums[i];
            if(i>=k-1){
                cur -= nums[i-k+1];
            }
        }
        return cur==0;
    }
}