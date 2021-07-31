/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 *
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (56.37%)
 * Likes:    3040
 * Dislikes: 759
 * Total Accepted:    615.4K
 * Total Submissions: 1.1M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers numbers that is already sorted in non-decreasing
 * order, find two numbers such that they add up to a specific target number.
 * 
 * Return the indices of the two numbers (1-indexed) as an integer array answer
 * of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * 
 * 
 */

// @lc code=start
class Solution {
 public int[] twoSum(int[] numbers, int target) {
  if (numbers == null)
   return null;
  int i = 0, j = numbers.length - 1;
  while (i < j) {
   int sum = numbers[i] + numbers[j];
   if (sum == target) {
    return new int[] { i + 1, j + 1 };
   } else if (sum < target) {
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