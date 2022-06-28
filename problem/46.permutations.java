class Solution {
    List<List<Integer>> res;
    List<Integer> track;
    boolean[] used;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        used = new boolean[nums.length];
        backTracking(nums);
        return res;
    }
    
    private void backTracking(int[] nums){
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        
        for(int i=0;i<nums.length;++i){
            if(used[i]){
                continue;
            }
            
            track.add(nums[i]);
            used[i] = true;
            backTracking(nums);
            used[i] = false;
            track.remove(track.size()-1);
        }
    }
}