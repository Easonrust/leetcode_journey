class Solution {
 public int[] searchRange(int[] nums, int target) {
  return new int[] { bsearch1(nums, target), bsearch2(nums, target) };
 }

 private int bsearch1(int[] nums, int target) {

  if (nums.length == 0) {
   return -1;
  }

  int l = 0;
  int r = nums.length - 1;
  while (l < r) {
   int mid = l + (r - l) / 2;
   if (nums[mid] >= target) {
    r = mid;
   } else {
    l = mid + 1;
   }
  }

  if (nums[l] == target) {
   return l;
  }

  return -1;
 }

 private int bsearch2(int[] nums, int target) {
  if (nums.length == 0) {
   return -1;
  }

  int l = 0;
  int r = nums.length - 1;
  while (l < r) {
   int mid = l + (r - l + 1) / 2;
   if (nums[mid] <= target) {
    l = mid;
   } else {
    r = mid - 1;
   }
  }

  if (nums[l] == target) {
   return l;
  }

  return -1;
 }
}

// yxc method