class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        
        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            int smallNum = getSmallNum(matrix, mid);
            if(smallNum>=k){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        
        return lo;
    }
    
    private int getSmallNum(int[][] matrix, int target){
        int n = matrix.length;
        int cnt = 0;
        for(int i=0; i<n; ++i){
            int[] row = matrix[i];
            int lo = 0;
            int hi = row.length-1;
            while(lo<=hi){
                int mid = lo + (hi-lo)/2;
                int num = row[mid];
                if(num<=target){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
            cnt += (hi-0+1);
        }
        return cnt;
    }
}