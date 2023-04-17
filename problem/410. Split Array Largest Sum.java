class Solution {
    public int splitArray(int[] nums, int k) {
        int r = 0;
        int l = 0;
        for(int num:nums){
            r += num;
            l = Math.max(l, num);
        }
        while(l<r) {
            int mid = l + (r-l)/2;
            if(check(nums, mid, k)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int x, int k) {
        int cnt = 0;
        int sum = 0;
        for(int num:nums) {
            if(sum+num>x){
                cnt++;
                sum = num;
            }else{
                sum+=num;
            }
        }
        cnt++;
        return cnt<=k;
    }
}