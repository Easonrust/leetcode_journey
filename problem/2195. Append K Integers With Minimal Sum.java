class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        long start = 1;
        for(int i=0; i<nums.length&&k>0; ++i){
            if(start<nums[i]){
                long count =  Math.min(nums[i] - start, k);
                long sum = (start+start+count-1)*count/2;
                res += sum;
                k -= count;
            }
            start = nums[i] + 1;
        }
        
        if(k>0){
            long sum = (start+start+k-1)*k/2;
            res += sum;
        }
        return res;
    }
}