/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
*/

// @lc code=start
class Solution {
 public int[] twoSum(int[] numbers, int target) {
  int i = 0, j = numbers.length - 1;
  while (i < j) {
   if (numbers[i] + numbers[j] == target) {
    return new int[] { i + 1, j + 1 };
   } else if (numbers[i] + numbers[j] < target) {
    i++;
   } else {
    j--;
   }
  }
  return null;
 }
}
// @lc code=end
// 这里使用双指针的方法两边寻找