class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chs1 = new int[26];
        int[] chs2 = new int[26];
        
        if(s.length()!=t.length()){
            return false;
        }
        
        for(char c:s.toCharArray()){
            chs1[c-'a']++;
        }
        
        for(char c:t.toCharArray()){
            chs2[c-'a']++;
        }
        
        for(int i=0;i<chs1.length;++i){
            if(chs1[i]!=chs2[i]){
                return false;
            }
        }
        
        return true;
    }
}