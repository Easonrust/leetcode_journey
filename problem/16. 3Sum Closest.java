class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int delta = Integer.MAX_VALUE;
        int res = 0;
        
        for(int i=0; i<nums.length-2; ++i){
            int first = nums[i];
            int sum = first + twoSumCloset(nums, i+1, target-first);
            if(Math.abs(target-sum)<delta){
                delta = Math.abs(target-sum);
                res = sum;
            }
        }
        
        return res;
    }
    
    private int twoSumCloset(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        int delta = Integer.MAX_VALUE;
        int res = 0;
        
        while(lo<hi){
            int first = nums[lo];
            int second = nums[hi];
            int sum = first + second;
            if(Math.abs(target-sum)<delta){
                delta = Math.abs(target-sum);
                res = sum;
            }
            
            if(sum<target){
                lo++;
            }else if(sum>target){
                hi--;
            }else{
                break;
            }
        }
        
        return res;
    }
}