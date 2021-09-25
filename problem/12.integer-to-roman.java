/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
 public String intToRoman(int num) {
  int[] nums = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
  String[] romans = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < nums.length; ++i) {
   while (num >= nums[i]) {
    num -= nums[i];
    sb.append(romans[i]);
   }
  }
  return sb.toString();
 }
}
// @lc code=end
// 先把数字所有的可能单位列举出来，然后使用贪心算法来实现
// 注意要从string的末尾开始构造数字
