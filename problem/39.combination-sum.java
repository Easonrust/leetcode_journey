class Solution {
    List<List<Integer>> res;
    List<Integer> track;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backTracking(candidates, 0, target, 0);
        return res;
    }
    
    private void backTracking(int[] candidates, int start, int target, int sum){
        if(sum==target){
            res.add(new ArrayList<>(track));
            return;
        }
        
        if(sum>target){
            return;
        }
        
        for(int i=start; i<candidates.length; ++i){
            track.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, i, target, sum);
            sum -= candidates[i];
            track.remove(track.size()-1);
        }
    }
}