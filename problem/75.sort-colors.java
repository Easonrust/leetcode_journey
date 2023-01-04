class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int head = 0;
        for(int i=0; i<n; ++i){
            if(nums[i]==0){
                swap(nums, head, i);
                head++;
            }
        }

        for(int i=head; i<n; ++i){
            if(nums[i]==1){
                swap(nums, head, i);
                head++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}