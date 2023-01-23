class Solution {
    List<List<String>> res;
    List<String> track;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backTracking(s);
        return res;
    }

    private void backTracking(String s) {
        if(s.length()==0){
            res.add(new ArrayList<>(track));
        }

        for(int i=0; i<s.length(); ++i) {
            if(isPalindrome(s.substring(0, i+1))){
                track.add(s.substring(0, i+1));
                backTracking(s.substring(i+1));
                track.remove(track.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}