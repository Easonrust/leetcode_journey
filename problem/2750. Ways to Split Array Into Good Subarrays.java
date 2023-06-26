class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int mod = 1000000007;
        long res = 1;
        List<Integer> posList = new ArrayList<>();
        for(int i = 0; i<nums.length; ++i){
            if(nums[i]==1){
                posList.add(i);
            }
        }
        if(posList.size()==0){
            return 0;
        }
        for(int i=1; i<posList.size(); ++i){
            res = (res*(long)(posList.get(i)-posList.get(i-1)))%mod;
        }
        return (int)res;
    }
}