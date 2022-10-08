class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0; i<nums.length-2; ++i){
            int sum = nums[i] + twoSumClosest(nums, i+1, target-nums[i]);
            if(delta>Math.abs(target-sum)){
                res = sum;
                delta = Math.abs(target-sum);
            }
        }
        return res;
    }
    
    private int twoSumClosest(int[] nums, int start, int target) {
        int l = start;
        int r = nums.length-1;
        int res = 0;
        int delta = Integer.MAX_VALUE;
        while(l<r) {
            int sum = nums[l] + nums[r];
            if(delta>Math.abs(target-sum)){
                delta = Math.abs(target-sum);
                res = sum;
            }
            if(sum>target){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}