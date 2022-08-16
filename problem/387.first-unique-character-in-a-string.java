class Solution {
    public int firstUniqChar(String s) {
        int[] cnts = new int[26];
        for(char c:s.toCharArray()){
            cnts[c-'a']++;
        }
        for(int i=0; i<s.length(); ++i) {
            if(cnts[s.charAt(i)-'a']==1){
                return i;
            }
        }
        
        return -1;
    }
}