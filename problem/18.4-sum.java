import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
 public List<List<Integer>> fourSum(int[] nums, int target) {
  int n = nums.length;
  List<List<Integer>> res = new ArrayList<>();
  if (n < 4) {
   return res;
  }

  Arrays.sort(nums);

  for (int i = 0; i < n - 3; ++i) {
   if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
   }
   for (int j = i + 1; j < n - 2; ++j) {
    if (j > i + 1 && nums[j] == nums[j - 1]) {
     continue;
    }
    int k = j + 1;
    int l = n - 1;
    while (k < l) {
     if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
      res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
      k++;
      l--;
      while (k < l && nums[k] == nums[k - 1]) {
       k++;
      }
      while (l > k && nums[l] == nums[l + 1]) {
       l--;
      }
     } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) {
      k++;
     } else {
      l--;
     }
    }
   }
  }
  return res;
 }
}
// @lc code=end
// 和第15题思路一样，外面再套一层循环即可
