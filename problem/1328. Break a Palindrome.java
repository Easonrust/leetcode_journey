class Solution {
    public String breakPalindrome(String palindrome) {
        int l = palindrome.length();
        StringBuilder sb = new StringBuilder(palindrome);
        
        if(l==1){
            return "";
        }
        
        for(int i=0; i<l/2;++i){
            if(sb.charAt(i)!='a'){
                sb.setCharAt(i,'a');
                return sb.toString();
            }
        }
        
        sb.setCharAt(l-1,'b');
        return sb.toString();
    }
}
