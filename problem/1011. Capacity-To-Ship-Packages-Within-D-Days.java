class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for(int weight:weights){
            l = Math.max(l, weight);
            r += weight;
        }
        while(l<r){
            int mid = l + (r-l)/2;
            if(helper(weights, mid)<=days){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    private int helper(int[] weights, int cap) {
        int res = 1;
        int i = 0;
        int sum = 0;
        while(i<weights.length){
            sum += weights[i];
            if(sum>cap){
                sum = weights[i];
                res++;
            }
            i++;
        }
        return res;
    }
}