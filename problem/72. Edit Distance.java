class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        memo = new int[l1][l2];
        for(int[] me:memo){
            Arrays.fill(me, -1);
        }
        return dp(l1-1, l2-1, word1, word2);
    }

    private int dp(int i, int j, String word1, String word2) {
        if(i==-1){
            return j+1;
        }

        if(j==-1){
            return i+1;
        }
        
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j] = dp(i-1, j-1, word1, word2);
        }else{
            memo[i][j] = Math.min(dp(i-1,j,word1,word2), Math.min(dp(i,j-1,word1,word2), dp(i-1,j-1,word1,word2)))+1;
        }

        return memo[i][j];
    }
}