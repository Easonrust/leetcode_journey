class Solution {
 public int threeSumSmaller(int[] nums, int target) {
  Arrays.sort(nums);
  int res = 0;
  for (int i = 0; i < nums.length - 2; ++i) {
   res += twoSumSmaller(nums, i + 1, target - nums[i]);
  }

  return res;
 }

 private int twoSumSmaller(int[] nums, int startIndex, int target) {
  int sum = 0;
  int l = startIndex;
  int h = nums.length - 1;
  while (l < h) {
   if (nums[l] + nums[h] < target) {
    sum += h - l;
    l++;
   } else {
    h--;
   }
  }
  return sum;
 }

}

// 和3sum不太一样，这道题没要求去重
