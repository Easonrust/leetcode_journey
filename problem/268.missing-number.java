/*
 * @lc app=leetcode id=268 lang=java
 *
 * [268] Missing Number
 */

// @lc code=start
class Solution {
 public int missingNumber(int[] nums) {
  Set<Integer> set = new HashSet<>();

  for (int num : nums) {
   set.add(num);
  }

  for (int i = 0; i < nums.length + 1; ++i) {
   if (!set.contains(i)) {
    return i;
   }
  }

  return -1;
 }
}

// 使用hashset达到O(n)的时间复杂度
// @lc code=end
