class Solution {
    List<List<Integer>> res;
    List<Integer> track;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backTracking(nums, 0);
        return res;
    }

    private void backTracking(int[] nums, int start) {
        if(track.size()>=2){
            res.add(new ArrayList<>(track));
        }
        Set<Integer> used = new HashSet<>();
        for(int i=start; i<nums.length; ++i) {
            if(track.size()>0&&nums[i]<track.get(track.size()-1)){
                continue;
            }
            if(used.contains(nums[i])){
                continue;
            }
            used.add(nums[i]);
            track.add(nums[i]);
            backTracking(nums, i+1);
            track.remove(track.size()-1);
        }
    }
}