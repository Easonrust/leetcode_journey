class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int[] diff = new int[length];
        for (int[] update : updates) {
            diff[update[0]] += update[2];
            if (update[1] + 1 < length) {
                diff[update[1] + 1] -= update[2];
            }
        }

        res[0] = diff[0];
        for (int i = 1; i < length; ++i) {
            res[i] = res[i - 1] + diff[i];
        }

        return res;
    }
}
