class Solution {
    public int[][] generateMatrix(int n) {
        int upperBound = 0;
        int lowerBound = n-1;
        int leftBound = 0;
        int rightBound = n-1;
        
        int[][] res = new int[n][n];
        
        int num = 1;
        while(num<=(n*n)){
            if(upperBound<=lowerBound){
                for(int j=leftBound; j<=rightBound; ++j){
                    res[upperBound][j] = num;
                    num++;
                }
                upperBound++;
            }
            
            if(leftBound<=rightBound){
                for(int i=upperBound; i<=lowerBound; ++i){
                    res[i][rightBound] = num;
                    num++;
                }
                rightBound--;
            }
            
            if(upperBound<=lowerBound){
                for(int j=rightBound; j>=leftBound; --j){
                    res[lowerBound][j] = num;
                    num++;
                }
                lowerBound--;
            }
            
            if(leftBound<=rightBound){
                for(int i=lowerBound; i>=upperBound; --i){
                    res[i][leftBound] = num;
                    num++;
                }
                leftBound++;
            }
        }
        
        return res;
    }
}