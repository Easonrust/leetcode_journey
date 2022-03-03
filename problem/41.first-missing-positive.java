// @lc code=start
class Solution {
 public int firstMissingPositive(int[] nums) {
  int n = nums.length;

  // Base case
  int contains = 0;
  for (int i = 0; i < n; i++) {
   if (nums[i] == 1) {
    contains++;
    break;
   }
  }

  // 说明数组中连1都没有，直接返回1
  if (contains == 0) {
   return 1;
  }

  for (int i = 0; i < n; ++i) {
   if ((nums[i] <= 0) || (nums[i] > n)) {
    nums[i] = 1;
   }
  }

  for (int i = 0; i < n; ++i) {
   int a = Math.abs(nums[i]);

   if (a == n) {
    nums[0] = -Math.abs(nums[0]);
   } else {
    nums[a] = -Math.abs(nums[a]);
   }
  }

  for (int i = 1; i < n; i++) {
   if (nums[i] > 0) {
    return i;
   }
  }

  if (nums[0] > 0) {
   return n;
  }

  return n + 1;
 }
}

// 缺失的第一个整数最大值应该是n+1,首先移除掉一定不符合条件的数字（将其变为1）
// 把数组中的值直接当成hashkey来使用，nums[a]如果为负号，说明a在数组出现过，否则没出现过
// @lc code=end
