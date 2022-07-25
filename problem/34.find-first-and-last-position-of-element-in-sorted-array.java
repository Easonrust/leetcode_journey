class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }
    
    private int findStart(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        while(l<=h){
            int mid = l + (h-l)/2;
            int num = nums[mid];
            if(num<target){
                l = mid + 1;
            }else if(num>target){
                h = mid - 1;
            }else{
                h = mid - 1;
            }
        }
        
        if(l>=nums.length||nums[l]!=target){
            return -1;
        }
        
        return l;
    }
    
    private int findEnd(int[] nums, int target){
        int l = 0;
        int h = nums.length - 1;
        while(l<=h){
            int mid = l + (h-l)/2;
            int num = nums[mid];
            if(num<target){
                l = mid + 1;
            }else if(num>target){
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        
        if(h<0||nums[h]!=target){
            return -1;
        }
        
        return h;
    }
}