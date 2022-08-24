class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);
            if(ch1!=ch2){
                return checkPalindrome(l+1, r, s) || checkPalindrome(l, r-1, s);
            }
            l++;
            r--;
        }
        return true;
    }
    
    private boolean checkPalindrome(int l, int r, String s){
        while(l<r){
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);
            if(ch1!=ch2){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}