class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int l = 0;
        int r = x / 2;
        long temp = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            temp = (long) mid * (long) mid;
            if (temp > x) {
                r = mid - 1;
            } else if (temp < x) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return r;
    }
}

// 当x大于2的时候，x应该在0到x/2之间