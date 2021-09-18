/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
 public int majorityElement(int[] nums) {
  int cnt = 0, major = nums[0];
  for (int num : nums) {
   if (cnt == 0) {
    major = num;
    cnt = 1;
   } else {
    cnt = major == num ? cnt + 1 : cnt - 1;
   }
  }
  return major;
 }
}
// @lc code=end
// 另一种解法是对数组进行排序，则最中间的那个数出现的次数一定大于n/2
// 本解法应用了摩尔投票法：使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素不相等时，令 cnt--。如果前面查找了 i 个元素，且 cnt
// == 0，说明前 i 个元素没有 majority，或者有 majority，但是出现的次数少于 i / 2，因为如果多于 i / 2 的话 cnt
// 就一定不会为 0。此时剩下的 n - i 个元素中，majority 的数目依然多于 (n - i) / 2，因此继续查找就能找出 majority。
