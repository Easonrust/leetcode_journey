class Solution {
    public int triangularSum(int[] nums) {
        int res = 0;
        int m = nums.length;
        while(m>1){
            int[] newNums = new int[m-1];
            for(int i=0; i<m-1; ++i){
                newNums[i] = nums[i] + nums[i+1];
            }
            for(int i=0; i<m-1; ++i){
                nums[i] = newNums[i]%10;
            }
            m--;
        }
        
        return nums[0];
    }
}
