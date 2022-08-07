class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int left = 0;
        int right = 0;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        while(right<nums.length){
            int in = nums[right];
            right ++;
            window.put(in, window.getOrDefault(in,0)+1);
            
            while(!checkDiff(window, limit)){
                int out = nums[left];
                left ++;
                window.put(out, window.get(out)-1);
                if(window.get(out)==0){
                    window.remove(out);
                }
            }
            
            res = Math.max(res, right-left);
        }
        
        return res;
    }
    
    private boolean checkDiff(TreeMap<Integer, Integer> window, int limit) {
        int min = window.firstKey();
        int max = window.lastKey();
        return (max-min)<=limit;
    }
}