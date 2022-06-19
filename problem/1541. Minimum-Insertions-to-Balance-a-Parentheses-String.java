class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int need = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                if (need % 2 != 0) {
                    res++;
                    need--;
                }
                need += 2;

            } else {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
