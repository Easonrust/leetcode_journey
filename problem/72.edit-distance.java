class Solution {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        int i = word1.length() - 1;
        int j = word2.length() - 1;
        memo = new int[word1.length()][word2.length()];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dp(i, j, word1, word2);
    }

    public int dp(int i, int j, String word1, String word2) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dp(i - 1, j - 1, word1, word2);
            return memo[i][j];
        } else {
            memo[i][j] = Math.min(dp(i, j - 1, word1, word2),
                    Math.min(dp(i - 1, j, word1, word2), dp(i - 1, j - 1, word1, word2))) + 1;
            return memo[i][j];
        }
    }
}