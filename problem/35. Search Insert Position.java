class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        while(l<=r){
            mid = l + (r-l)/2;
            if(nums[mid]<target){
                l = mid+1;
            }else if(nums[mid]>target){
                r = mid-1;
            }else{
                return mid;
            }
        }
        
        
        return l;
    }
}