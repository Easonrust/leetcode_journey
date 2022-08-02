class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int zeros = 0;
        int res = 0;
        while(right<n){
            int in = nums[right];
            right++;
            if(in==0){
                zeros++;
            }
            
            while(zeros>k){
                int out = nums[left];
                left++;
                if(out==0){
                    zeros--;
                }
            }
            
            res = Math.max(res, right-left);
        }
        
        return res;
    }
}
