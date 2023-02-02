class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        for(int i=0; i<n-1; ++i){
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.startsWith(word2)&&word1.length()>word2.length()){
                return false;
            }
            for(int j=0; j<Math.min(word1.length(), word2.length()); ++j){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if(ch1==ch2){
                    continue;
                }
                if(order.indexOf(ch1)>order.indexOf(ch2)){
                    return false;
                }else{
                    break;
                }
            }
        }
        return true;
    }
}