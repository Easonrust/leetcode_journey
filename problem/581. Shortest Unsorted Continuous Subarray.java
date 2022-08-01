class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int minFromLast = Integer.MAX_VALUE;
        int maxFromStart = Integer.MIN_VALUE;
        
        int left = -1;
        int right = -1;
        int n = nums.length;
        for(int i=n-1; i>=0; --i){
            if(nums[i]<=minFromLast){
                minFromLast = nums[i];
            }else{
                left = i;
            }
        }
        
        for(int i=0; i<n; ++i){
            if(nums[i]>=maxFromStart){
                maxFromStart = nums[i];
            }else{
                right = i;
            }
        }
        
        if(right==-1){
            return 0;
        }
        
        return right-left+1;
    }
}