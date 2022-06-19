class Solution {
    public int minAddToMakeValid(String s) {
        int leftNeed = 0;
        int rightNeed = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                rightNeed++;
            } else {
                rightNeed--;
                if (rightNeed == -1) {
                    rightNeed = 0;
                    leftNeed++;
                }
            }
        }
        return leftNeed + rightNeed;
    }
}

// 以左边为基准
