class Solution {
 public int missingElement(int[] nums, int k) {
  if (nums.length == 1) {
   return nums[0] + 1;
  }
  int i = 1;

  int missingCnt = nums[i] - nums[0] - i;
  while (missingCnt < k && i < nums.length) {
   i++;
   if (i < nums.length) {
    missingCnt = nums[i] - nums[0] - i;
   }
  }

  return k + nums[0] + i - 1;
 }
}