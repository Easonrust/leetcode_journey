class Leaderboard {

    private HashMap<Integer, Integer> scoreForId;
    private TreeMap<Integer, Integer> scoreTimes;

    public Leaderboard() {
        scoreForId = new HashMap<>();
        scoreTimes = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (!scoreForId.containsKey(playerId)) {
            scoreForId.put(playerId, score);
            scoreTimes.put(score, scoreTimes.getOrDefault(score, 0) + 1);
        } else {
            int preScore = scoreForId.get(playerId);
            int preCnt = scoreTimes.get(preScore);
            scoreTimes.put(preScore, preCnt - 1);

            int curScore = preScore + score;
            scoreTimes.put(curScore, scoreTimes.getOrDefault(curScore, 0) + 1);
            scoreForId.put(playerId, curScore);
        }
    }

    public int top(int K) {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : scoreTimes.entrySet()) {
            int times = entry.getValue();
            int score = entry.getKey();
            for (int i = 0; i < times; ++i) {
                sum += score;
                K--;
                if (K == 0) {
                    break;
                }
            }
            if (K == 0) {
                break;
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        int preScore = scoreForId.get(playerId);
        int preCnt = scoreTimes.get(preScore);
        scoreTimes.put(preScore, preCnt - 1);

        int curScore = 0;
        scoreTimes.put(curScore, scoreTimes.getOrDefault(curScore, 0) + 1);
        scoreForId.put(playerId, curScore);
    }
}
// 使用TreeMap实现leaderboard
/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
