class Solution {
    List<Integer> track = new ArrayList<>();
    boolean find = false;
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        track.add(0);
        backTracking(0, 0, derived);
        track.remove(track.size()-1);
        track.add(1);
        backTracking(1, 0, derived);
        track.remove(track.size()-1);
        return find;
    }
    
    private void backTracking(int cur, int i, int[] derived) {
        if(find==true){
            return;
        }
        int next = 1;
        if(i+1==derived.length){
            next = track.get(0);
            if((int)(cur^next)==derived[i]){
                find = true;
            }
            return;
        }
        for(int bit=0; bit<=1; ++bit){
            next = bit;
            if((int)(cur^next)==derived[i]){
                track.add(next);
                backTracking(next, i+1, derived);
                track.remove(track.size()-1);
            }
        }
    }
}