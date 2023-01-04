class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(s, wordDict, 0);
    }

    private boolean dp(String s, List<String> wordDict, int i) {
        if(i==s.length()){
            return true;
        }
        if(memo[i]!=-1){
            if(memo[i]==1){
                return true;
            }else{
                return false;
            }
        }

        for(String word:wordDict) {
            int len = word.length();
            if(i+len>s.length()){
                continue;
            }
            String subStr = s.substring(i, i+len);
            if(word.equals(subStr)){
                if(dp(s, wordDict, i+len)){
                    memo[i] = 1;
                    return true;
                }
            }
        }

        memo[i] = 0;
        return false;
    }
}