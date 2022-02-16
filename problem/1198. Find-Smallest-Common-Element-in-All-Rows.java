class Solution {
    public int smallestCommonElement(int[][] mat) {
        int count[] = new int[10001];
        int n = mat.length, m = mat[0].length;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (++count[mat[i][j]] == n) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }
}

// 因为要找最小的，所以逐列比较，能更快的找到小的元素是否符合条件，从而退出循环
