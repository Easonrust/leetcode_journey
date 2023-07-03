class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int res = 0;
        for(int i=0; i<nums.length; ++i){
            if(!(nums[i]%2==0&&nums[i]<=threshold)){
                continue;
            }
            int len = getLength(nums, i, threshold);
            res = Math.max(res, len);
        }
        return res;
    }
    
    private int getLength(int[] nums, int i, int threshold){
        int len = 1;
        for(int j=i+1; j<nums.length; ++j){
            if(((nums[j]%2)==(nums[j-1]%2))||nums[j]>threshold){
                break;
            }
            len++;
        }
        return len;
    }
}