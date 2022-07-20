class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo,-1);
        return dp(s, 0, wordDict);
    }
    
    private boolean dp(String s, int i, List<String> wordDict) {
        if(i==s.length()){
            return true;
        }
        
        if(memo[i]==0){
            return false;
        }
        
        if(memo[i]==1){
            return true;
        }
        
        for(String word:wordDict){
            int len = word.length();
            if(i+len>s.length()){
                continue;
            }
            String subStr = s.substring(i, i+len);
            if(subStr.equals(word)){
                if(dp(s, i+len, wordDict)){
                    memo[i] = 1;
                    return true;
                }
            }
        }
        
        memo[i] = 0;
        return false;
    }
}