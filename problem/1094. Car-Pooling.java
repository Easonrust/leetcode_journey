class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        int[] res = new int[1001];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            if (trip[2] < 1001) {
                diff[trip[2]] -= trip[0];
            }
        }

        res[0] = diff[0];
        if (res[0] > capacity) {
            return false;
        }
        for (int i = 1; i < 1001; i++) {
            res[i] = res[i - 1] + diff[i];
            if (res[i] > capacity) {
                return false;
            }
        }

        return true;

    }
}

// 差分数组
