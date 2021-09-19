import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
 public List<List<Integer>> threeSum(int[] nums) {
  int n = nums.length;
  List<List<Integer>> res = new ArrayList<>();

  // 注意这里不能直接return null
  if (n < 3) {
   return res;
  }
  Arrays.sort(nums);

  for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {

   // 去重
   if (i > 0 && nums[i] == nums[i - 1]) {
    continue;
   }
   int j = i + 1;
   int k = n - 1;
   while (j < k) {
    if (nums[i] + nums[j] + nums[k] == 0) {
     res.add(Arrays.asList(nums[i], nums[j], nums[k]));
     j++;
     k--;

     // 去重
     while (j < n && nums[j] == nums[j - 1]) {
      j++;
     }

     // 去重，注意这里应该是比较k+1，才能包含所有元素(每个指针所运动的区域应该是独立的)
     while (k > j && nums[k] == nums[k + 1]) {
      k--;
     }
    } else if (nums[i] + nums[j] + nums[k] < 0) {
     j++;
    } else {
     k--;
    }
   }
  }
  return res;
 }
}
// @lc code=end
// 先对数组进行排序，然后使用双指针法解决问题
