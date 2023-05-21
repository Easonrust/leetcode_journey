class Solution {
    public String makeSmallestPalindrome(String s) {
        int left = 0;
        int leftEnd = s.length()/2-1;
        int j = s.length() - 1;
        char[] chArr = s.toCharArray();
        for(int i=left; i<=leftEnd; ++i){
            if(chArr[i]-'a'<chArr[j]-'a'){
                chArr[j] = chArr[i];
            }else{
                chArr[i] = chArr[j];
            }
            j--;
        }
        return new String(chArr);
    }
}