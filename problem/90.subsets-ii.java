class Solution {
    List<List<Integer>> res;
    List<Integer> track;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        track = new ArrayList<>();
        backTracking(nums, 0);
        return res;
    }
    
    private void backTracking(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        
        for(int i=start; i<nums.length; ++i){
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            backTracking(nums, i+1);
            track.remove(track.size()-1);
        }
    }
}