class Solution {
    public int minOperations(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        x = sum - x;
        if(x<0){
            return -1;
        }
        sum = 0;
        int maxLength = Integer.MIN_VALUE;
        while(right<n){
            int in = nums[right];
            sum += in;
            right++;
            
            while(sum>x&&left<n){
                int out = nums[left];
                sum -= out;
                left++;
            }
            
            if(sum==x){
                maxLength = Math.max(maxLength, right-left);
            }
        }
        
        if(maxLength==Integer.MIN_VALUE){
            return -1;
        }
        
        return n-maxLength;
    }
}
