class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] frontPoints = new int[n + 1];
        int[] backPoints = new int[n + 1];

        for (int i = 0; i < k; i++) {
            frontPoints[i + 1] = cardPoints[i] + frontPoints[i];
            backPoints[i + 1] = cardPoints[n - i - 1] + backPoints[i];
        }

        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, frontPoints[i] + backPoints[k - i]);
        }

        return res;
    }
}

// frontPoints[i]中存从前端取i个card获得的points
// backPoints[i]中存从后端取i个card获得的points
