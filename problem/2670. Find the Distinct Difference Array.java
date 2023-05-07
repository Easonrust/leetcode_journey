class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i=0; i<n; ++i){
            set1.add(nums[i]);
            left[i] = set1.size();
        }
        
        for(int i=n-1; i>=0; --i){
            set2.add(nums[i]);
            right[i] = set2.size();
        }
        
        for(int i=0; i<n; ++i){
            int prefix = left[i];
            int suffix = (i+1)<n ? right[i+1] : 0;
            res[i] = prefix - suffix;
        }
        return res;
    }
}