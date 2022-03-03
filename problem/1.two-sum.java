import java.util.HashMap;
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
