class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()==0){
            return -1;
        }
        
        if(needle.length()==0){
            return 0;
        }
        
        for(int i=0; i<(haystack.length()-needle.length()+1); ++i){
            for(int j=0; j<needle.length(); ++j){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==needle.length()-1){
                    return i;
                }
            }
        }
        
        return -1;
    }
}
