class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int[] dp = new int[s.length() + 1];
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i + 1] = 0;
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    dp[i + 1] = 0;
                } else {
                    int idx = stack.pop();
                    int len = i - idx + 1 + dp[idx];
                    dp[i + 1] = len;
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}