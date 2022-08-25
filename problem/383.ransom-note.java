class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnts1 = new int[26];
        int[] cnts2 = new int[26];
        for(char ch:magazine.toCharArray()){
            cnts1[ch-'a']++;
        }
        
        for(char ch:ransomNote.toCharArray()){
            cnts2[ch-'a']++;
            if(cnts2[ch-'a']>cnts1[ch-'a']){
                return false;
            }
        }
        
        return true;
    }
}