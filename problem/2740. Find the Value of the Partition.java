class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; ++i){
            res = Math.min(res, Math.abs(nums[i]-nums[i-1]));
        }
        return res;
    }
}