class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int[] diff = new int[n];

        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] - 1 + 1 < n) {
                diff[booking[1] - 1 + 1] -= booking[2];
            }
        }

        res[0] = diff[0];
        for (int i = 1; i < n; ++i) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }
}

// 差分数组
