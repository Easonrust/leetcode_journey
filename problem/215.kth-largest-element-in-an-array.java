class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        int p = partition(nums, lo, hi);
        while(p!=(n-k)){
            if(p<n-k){
                lo = p+1;
                p = partition(nums, lo, hi);
            }else{
                hi = p-1;
                p = partition(nums, lo, hi);
            }
        }
        return nums[p];
    }

    public int partition(int[] nums, int lo, int hi) {
        int randIdx = rand.nextInt(hi-lo+1) + lo;
        swap(nums, lo, randIdx);
        int pivot = nums[lo];
        int p = lo;
        for(int i=lo+1; i<=hi; ++i){
            if(nums[i]<pivot){
                p++;
                swap(nums, p, i);
            }
        }
        swap(nums, p, lo);
        return p;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}