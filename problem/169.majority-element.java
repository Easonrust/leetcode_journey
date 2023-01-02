class Solution {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int cnt = 0;
        for(int i=0; i<nums.length; ++i){
            if(cnt==0){
                target = nums[i];
                cnt = 1;
            }else{
                if(target==nums[i]){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        return target;
    }
}