class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        Map<Integer, Integer> dp = new HashMap<>();
        for(int i:arr){
            dp.put(i, dp.getOrDefault(i-difference, 0)+1);
            ans = Math.max(ans, dp.get(i));
        }
        return ans;
    }
}