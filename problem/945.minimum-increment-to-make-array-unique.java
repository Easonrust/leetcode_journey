class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int curMax = nums[0];
        int res = 0;
        for(int i=1; i<nums.length; ++i){
            if(nums[i]<=curMax){
                curMax++;
                res += (curMax-nums[i]);
            }else{
                curMax = nums[i];
            }
        }
        return res;
    }
}