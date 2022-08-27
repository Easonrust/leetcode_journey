class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0; i<s.length(); ++i){
            String s1 = palinStr(s, i, i);
            String s2 = palinStr(s, i, i+1);
            if(res.length()<s1.length()){
                res = s1;
            }
            if(res.length()<s2.length()){
                res = s2;
            }
        }
        return res;
    }
    
    private String palinStr(String s, int l, int r) {
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        
        return s.substring(l+1, r);
    }
}