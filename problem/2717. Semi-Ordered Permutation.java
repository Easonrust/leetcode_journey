class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int pos1 = -1;
        int pos2 = -1;
        for(int i=0; i<n; ++i){
            if(nums[i]==1){
                pos1 = i;
            }
            if(nums[i]==n){
                pos2 = i;
            }
        }
        int res = 0;
        if(pos1<pos2){
            res = (pos1-0) + (n-1-pos2);
        }else{
            res = (pos2-0) + (n-1-pos1) + ((pos1-pos2)*2-1);
        }
        return res;
    }
}