class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int num = 1;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        while(num<=n*n){
            if(top<=bottom){
                for(int j=left; j<=right; ++j){
                    mat[top][j] = num;
                    num++;
                }
                top++;
            }

            if(right>=left){
                for(int i=top; i<=bottom; ++i){
                    mat[i][right] = num;
                    num++;
                }
                right--;
            }

            if(bottom>=top){
                for(int j=right; j>=left; --j){
                    mat[bottom][j] = num;
                    num++;
                }
                bottom--;
            }

            if(left<=right){
                for(int i=bottom; i>=top; --i){
                    mat[i][left] = num;
                    num++;
                }
                left++;
            }
        }
        return mat;
    }
}