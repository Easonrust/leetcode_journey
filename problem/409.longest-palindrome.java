class Solution {
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for(char c:s.toCharArray()){
            cnts[c]++;
        }
        int res = 0;
        for(int cnt:cnts){
            res += (cnt/2*2);
        }

        if(res<s.length()){
            res++;
        }
        return res;
    }
}