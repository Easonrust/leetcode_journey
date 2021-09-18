/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
 public int removeDuplicates(int[] nums) {
  int cnt = 0, cur = 1;
  for (int i = 1; i < nums.length; ++i) {
   if (nums[i] == nums[i - 1]) {
    cnt++;
   } else {
    cnt = 0;
   }
   if (cnt < 2) {
    nums[cur] = nums[i];
    cur++;
   }
  }
  return cur;
 }
}
// @lc code=end
// 注意本题中cnt是重复的次数，而不是出现的次数
// 从数组下标 1 开始遍历数组。

// 用计数器 cnt 记录当前数字重复出现的次数，cnt 的最小计数为 0；用 cur 记录新数组下个待覆盖的元素位置。

// 遍历时，若当前元素 nums[i] 与上个元素 nums[i-1] 相同，则计数器 +1，否则计数器重置为 0。如果计数器小于 2，说明当前元素
// nums[i] 可以添加到新数组中，即：nums[cur] = nums[i]，同时 cur++。

// 遍历结果，返回 cur 值即可。
