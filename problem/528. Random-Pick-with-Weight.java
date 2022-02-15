class Solution {
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        prefixSums = new int[w.length];
        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            prefixSums[i] = prefixSum;
        }
        totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = totalSum * Math.random();
        int left = 0;
        int right = prefixSums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// 例如[1,2,3,4,3]
// 扩展成[0, 1,1, 2,2,2, 3,3,3,3, 4,4,4]
// 随机投一个点为target，找最小的比target打的区间
// https://leetcode.com/problems/random-pick-with-weight/solution/
