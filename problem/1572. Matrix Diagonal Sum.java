class Solution {
    public int diagonalSum(int[][] mat) {
        int m = mat.length;
        int res1 = 0;
        for(int i=0; i<m; ++i){
            res1+=mat[i][i];
        }
        int res2 = 0;
        for(int i=m-1; i>=0; --i){
            res2+=mat[m-1-i][i];
        }
        if(m%2!=0){
            res2 -= mat[m/2][m/2];
        }
        return res1 + res2;
    }
}