class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int upperbound = 0;
        int lowerbound = m-1;
        int leftbound = 0;
        int rightbound = n-1;
        while(res.size()<m*n){
            if(upperbound<=lowerbound){
                for(int j=leftbound; j<=rightbound; j++){
                    res.add(matrix[upperbound][j]);
                }
                upperbound++;
            }
            if(rightbound>=leftbound){
                for(int i=upperbound; i<=lowerbound; i++){
                    res.add(matrix[i][rightbound]);
                }
                rightbound--;
            }
            if(lowerbound>=upperbound){
                for(int j=rightbound; j>=leftbound; j--){
                    res.add(matrix[lowerbound][j]);
                }
                lowerbound--;
            }
            if(leftbound<=rightbound){
                for(int i=lowerbound; i>=upperbound; i--){
                    res.add(matrix[i][leftbound]);
                }
                leftbound++;
            }
        }
        return res;
    }
}