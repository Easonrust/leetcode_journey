class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        int[][] chs2s = new int[words2.length][26];
        
        for(int i=0; i<words2.length; ++i){
            chs2s[i] = getChs(words2[i]);
        }
        
        int[] chs2max = new int[26];
        for(int[] chs2:chs2s){
            for(int i=0; i<26; ++i){
                chs2max[i] = Math.max(chs2max[i], chs2[i]);
            }
        }
        
        for(String word1:words1){
            int[] chs1 = getChs(word1);
            if(isSubset(chs1, chs2max)){
                res.add(word1);
            }
        }
        return res;
    }
    
    private boolean isSubset(int[] chs1, int[] chs2){        
        for(int i=0; i<26; ++i){
            if(chs1[i]<chs2[i]){
                return false;
            }
        }
        
        return true;
    }
    
    private int[] getChs(String word) {
        int[] chs = new int[26];
        for(char c:word.toCharArray()){
            chs[c-'a']++;
        }
        return chs;
    }
}

// 首先找出word 2中最强大的
