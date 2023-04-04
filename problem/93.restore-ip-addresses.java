class Solution {
    List<String> res;
    List<String> track;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        backTracking(0, s);
        return res;
    }

    private void backTracking(int start, String s) {
        if(start==s.length()&&track.size()==4){
            res.add(String.join(".", track));
        }

        for(int i=start; i<s.length(); ++i){
            String subStr = s.substring(start, i+1);
            if(!isValid(subStr)){
                continue;
            }
            if(track.size()>=4){
                break;
            }
            track.add(subStr);
            backTracking(i+1, s);
            track.remove(track.size()-1);
        }
    }

    private boolean isValid(String s) {
        if(s.length()==0||s.length()>3){
            return false;
        }

        if(s.length()==1){
            return true;
        }

        if(s.charAt(0)=='0'){
            return false;
        }

        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }
}