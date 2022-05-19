class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            min = nums[i];
            max = nums[i];
            for (int j = i; j < nums.length; ++j) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }

        return res;
    }
}
