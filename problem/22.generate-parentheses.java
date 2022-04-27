class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backTracking(n, n, sb);
        return res;
    }

    private void backTracking(int left, int right, StringBuilder sb) {
        if (left > right) {
            return;
        }

        if (left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            res.add(sb.toString());
        }

        sb.append('(');
        backTracking(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(')');
        backTracking(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}