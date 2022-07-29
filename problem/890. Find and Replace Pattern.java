class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for(String word:words){
            if(isMatch(word, pattern)){
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean isMatch(String word, String pattern) {
        if(word.length()!=pattern.length()){
            return false;
        }
        
        Map<Character, Character> p1 = new HashMap<>();
        Map<Character, Character> p2 = new HashMap<>();
        
        for(int i=0; i<word.length(); ++i){
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            p1.put(c2, c1);
            p2.put(c1, c2);
        }
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<word.length(); ++i){
            char c1 = word.charAt(i);
            char c2 = pattern.charAt(i);
            sb1.append(p1.get(c2));
            sb2.append(p2.get(c1));
        }
        
        return sb1.toString().equals(word) && sb2.toString().equals(pattern);
    }
}
