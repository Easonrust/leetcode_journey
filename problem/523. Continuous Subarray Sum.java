class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int remainder = 0;
        Map<Integer, Integer> idxForRemainder = new HashMap<>();
        idxForRemainder.put(0, -1);
        
        for(int i=0; i<nums.length; ++i){
            remainder = (remainder + nums[i])%k;
            if(idxForRemainder.containsKey(remainder)){
                int idx = idxForRemainder.get(remainder);
                if(i-idx>=2){
                    return true;
                }
            }else{
                idxForRemainder.put(remainder, i);
            }
        }
        
        return false;
    }
}