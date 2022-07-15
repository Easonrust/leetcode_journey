class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, 1, k);
        return res;
    }
    
    private void backTracking(int n, int start, int k) {
        if(track.size()==k){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=start; i<=n; ++i){
            track.add(i);
            backTracking(n, i+1, k);
            track.remove(track.size()-1);
        }
    }
}