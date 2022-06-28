class Solution {
    Map<String, Integer> memo;
    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, 0, target);
    }
    
    public int dp(int[] nums, int i, int remain){
        if(i==nums.length){
            if(remain==0){
                return 1;
            }
            return 0;
        }
        
        String key = i + "," + remain;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int result = dp(nums, i+1, remain+nums[i]) + dp(nums, i+1, remain-nums[i]);
        memo.put(key, result);
        return result;
    }
}