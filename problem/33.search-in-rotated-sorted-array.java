// @lc code=start
class Solution {
 public int search(int[] nums, int target) {
  int l = 0;
  int h = nums.length - 1;
  while (l < h) {
   int mid = l + (h - l) / 2;
   if (nums[mid] < nums[h]) {
    h = mid;
   } else {
    l = mid + 1;
   }
  }
  int l1 = 0;
  int h1 = l - 1;
  while (l1 <= h1) {
   int mid = l1 + (h1 - l1) / 2;
   if (nums[mid] == target) {
    return mid;
   } else if (nums[mid] < target) {
    l1 = mid + 1;
   } else {
    h1 = mid - 1;
   }
  }

  int l2 = l;
  int h2 = nums.length - 1;
  while (l2 <= h2) {
   int mid = l2 + (h2 - l2) / 2;
   if (nums[mid] == target) {
    return mid;
   } else if (nums[mid] < target) {
    l2 = mid + 1;
   } else {
    h2 = mid - 1;
   }
  }
  return -1;
 }
}

// 对于旋转数组的查找问题，先找到最小值的索引
// @lc code=end
