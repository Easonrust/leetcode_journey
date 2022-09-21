class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        nums[queries[0][1]] += queries[0][0];
        res[0] = getEvenSum(nums);
        for(int i=1; i<n; ++i){
            int[] query = queries[i];
            int oldNum = nums[query[1]];
            nums[query[1]] += query[0];
            if(oldNum%2==0){
                if(query[0]%2==0){
                    res[i] = res[i-1] + query[0];
                }else{
                    res[i] = res[i-1] - oldNum;
                }
            }else{
                if(query[0]%2==0){
                    res[i] = res[i-1];
                }else{
                    res[i] = res[i-1] + nums[query[1]];
                }
            }
        }
        return res;
    }
    
    private int getEvenSum(int[] nums){
        int res = 0;
        for(int num:nums){
            if(num%2==0){
                res+=num;
            }
        }
        return res;
    }
}
