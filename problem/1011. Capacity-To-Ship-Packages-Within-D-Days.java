class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int weight : weights) {
            r += weight;
            l = Math.max(l, weight);
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (getTime(weights, mid) > days) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private int getTime(int[] weights, int k) {
        int t = 0;
        int i = 0;

        int sum = 0;
        while (i < weights.length) {
            sum += weights[i];
            if (sum > k) {
                t++;
                sum = 0;
            } else if (i == weights.length - 1) {
                t++;
                i++;
            } else {
                i++;
            }
        }
        return t;
    }
}