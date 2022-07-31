class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0; i<nums.length; ++i){
            if(nums[i]==0){
                nums[i] = -1;
            }
        }
        
        Map<Integer, Integer> idxForSum = new HashMap<>();
        
        idxForSum.put(0, -1);
        int sum = 0;
        
        int res = 0;
        for(int i=0; i<nums.length; ++i){
            sum = sum + nums[i];
            if(idxForSum.containsKey(sum)){
                int idx = idxForSum.get(sum);
                res = Math.max(res, i-idx);
            }else{
                idxForSum.put(sum, i);
            }
        }
        
        
        return res;
    }
}
