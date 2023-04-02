class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int leftBound = nums[0];
        int moveCnt = 0;
        for(int i=1; i<nums.length; ++i){
            if(nums[i]<=leftBound){
                leftBound ++;
                moveCnt += (leftBound-nums[i]);
            }else{
                leftBound = nums[i];
            }
        }
        return moveCnt;
    }
}