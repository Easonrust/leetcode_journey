import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (47.29%)
 * Likes:    22884
 * Dislikes: 768
 * Total Accepted:    4.6M
 * Total Submissions: 9.8M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * Only one valid answer exists.
 * 
 * 
 * 
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time
 * complexity?
 */

// @lc code=start
class Solution {

 // 使用双指针法时，数组应该是有序的
 // public int[] twoSum(int[] nums, int target) {
 // int start=0;
 // int end=nums.length-1;
 // while(start<end){
 // if(nums[start]+nums[end]==target){
 // return new int[]{start,end};
 // }else if(nums[start]+nums[end]>target){
 // end--;
 // }else{
 // start++;
 // }
 // }
 // return new int[]{-1,-1};
 // }

 public int[] twoSum(int[] nums, int target) {
  Map<Integer, Integer> idxForNums = new HashMap<>();
  for (int i = 0; i < nums.length; ++i) {
   if (idxForNums.containsKey(target - nums[i])) {
    return new int[] { i, idxForNums.get(target - nums[i]) };
   } else {
    idxForNums.put(nums[i], i);
   }
  }
  return null;
 }
}
// @lc code=end
// 用 HashMap 存储数组元素和索引的映射，在访问到 nums[i] 时，判断 HashMap 中是否存在 target -
// nums[i]，如果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。该方法的时间复杂度为 O(N)，空间复杂度为
// O(N)，使用空间来换取时间。
