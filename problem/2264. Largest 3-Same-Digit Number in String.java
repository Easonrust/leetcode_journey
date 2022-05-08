class Solution {
    public String largestGoodInteger(String num) {
        int cur = -1;
        String res = "";
        if (num.length() < 3) {
            return res;
        }
        for (int i = 0; i < num.length() - 2; ++i) {
            String temp = num.substring(i, i + 3);
            if (isGood(num.substring(i, i + 3))) {
                if (num.charAt(i) - '0' > cur) {
                    cur = num.charAt(i) - '0';
                    res = temp;
                }
            }
        }
        return res;
    }

    public boolean isGood(String num) {
        if (num.charAt(0) == num.charAt(1) && num.charAt(1) == num.charAt(2)) {
            return true;
        }
        return false;
    }
}
