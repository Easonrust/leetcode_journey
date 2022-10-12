class Solution {
    public int largestPerimeter(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; --i){
            if(nums[i]<nums[i-1]+nums[i-2]){
                res = Math.max(res, nums[i]+nums[i-1]+nums[i-2]);
            }
        }
        return res;
    }
}