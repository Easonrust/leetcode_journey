class Solution {
    long[] memo;
    public long mostPoints(int[][] questions) {
        memo = new long[questions.length];
        Arrays.fill(memo, -1);
        return dp(questions, 0);
    }

    private long dp(int[][] questions, int i) {
        if(i>=questions.length){
            return 0;
        }
        if(memo[i]!=-1){
            return memo[i];
        }
        int[] question = questions[i];
        long score1 = (long)question[0] + dp(questions, i+question[1]+1);
        long score2 = dp(questions, i+1);
        memo[i] = Math.max(score1, score2);
        return memo[i];
    }
}