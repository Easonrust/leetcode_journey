class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        long res = 0;
        boolean[] cols = new boolean[n];
        boolean[] rows = new boolean[n];
        int colCnt = 0;
        int rowCnt = 0;
        for(int i=queries.length-1; i>=0; i--){
            int[] query = queries[i];
            int type = query[0];
            int idx = query[1];
            long val = query[2];
            if(type==0){
                if(rows[idx]==true){
                    continue;
                }else{
                    res += (n-colCnt)*val;
                    rowCnt++;
                    rows[idx] = true;
                }
            }else{
                if(cols[idx]==true){
                    continue;
                }else{
                    res += (n-rowCnt)*val;
                    colCnt++;
                    cols[idx] = true;
                }
            }
            if(colCnt==n&&rowCnt==n){
                break;
            }
        }
        return res;
    }
}