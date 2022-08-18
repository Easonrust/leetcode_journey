class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word:words){
            String str = getStr(word);
            set.add(str);
        }
        
        return set.size();
    }
    
    public String getStr(String word) {
        String[] codeMap = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<word.length(); ++i){
            char ch = word.charAt(i);
            sb.append(codeMap[ch-'a']);
        }
        
        return sb.toString();
    }
}
