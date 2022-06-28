class PrefixSum {
    private int[] sums;
   
    public PrefixSum(int[] nums) {
     sums = new int[nums.length + 1];
     sums[0] = 0;
     for (int i = 1; i <= nums.length; ++i) {
      sums[i] = sums[i - 1] + nums[i - 1];
     }
    }
   
    public int sumRange(int left, int right) {
     return sums[right + 1] - sums[left];
    }
   }
