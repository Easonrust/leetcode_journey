class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithKDistinctMost(nums, k) - subarraysWithKDistinctMost(nums, k-1);
    }

    private int subarraysWithKDistinctMost(int[] nums, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> cntForNum = new HashMap<>();
        int cnt = 0;
        while(right<nums.length){
            int in = nums[right];
            right++;
            cntForNum.put(in, cntForNum.getOrDefault(in, 0)+1);
            while(cntForNum.keySet().size()>k){
                int out = nums[left];
                left++;
                cntForNum.put(out, cntForNum.get(out)-1);
                if(cntForNum.get(out)==0){
                    cntForNum.remove(out);
                }
            }
            cnt+=right - left;
        }
        return cnt;
    }
}