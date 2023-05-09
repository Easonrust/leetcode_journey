class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m - 1;
        while(res.size()<m*n){
            if(up<=down){
                for(int j=left; j<=right; ++j){
                    res.add(matrix[up][j]);
                }
                up++;
            }

            if(right>=left){
                for(int i=up; i<=down; ++i){
                    res.add(matrix[i][right]);
                }
                right--;
            }

            if(down>=up){
                for(int j=right; j>=left; --j){
                    res.add(matrix[down][j]);
                }
                down--;
            }

            if(left<=right){
                for(int i=down; i>=up; --i){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}