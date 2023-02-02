class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] idx = new Integer[n];
        for(int i=0; i<n; ++i){
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b) -> (ages[a]!= ages[b] ? ages[a]-ages[b] : scores[a]-scores[b]));
        int[] dp = new int[n];
        int res = 0;
        for(int i=0; i<n; ++i){
            int curScore = scores[idx[i]];
            dp[i] = curScore;
            for(int j=0; j<i; ++j){
                if(scores[idx[j]]<=curScore){
                    dp[i] = Math.max(dp[i], dp[j]+curScore);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}