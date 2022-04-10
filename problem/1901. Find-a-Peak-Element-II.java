class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat[0].length, m = mat.length, l = 0, h = n - 1, max = 0;

        while (l < h) {
            int mid = l + (h - l) / 2;

            max = getMaxFromCol(mat, mid);
            if (mid != n - 1 && mat[max][mid] > mat[max][mid + 1]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return new int[] { getMaxFromCol(mat, h), h };

    }

    private int getMaxFromCol(int[][] mat, int mid) {
        int max = 0, m = mat.length;
        for (int i = 0; i < m; i++) {
            if (mat[i][mid] > mat[max][mid]) {
                max = i;
            }
        }
        return max;
    }
}
