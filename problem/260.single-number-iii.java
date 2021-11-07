/*
 * @lc app=leetcode id=260 lang=java
 *
 * [260] Single Number III
 */

// @lc code=start
class Solution {
 public int[] singleNumber(int[] nums) {
  int[] res = new int[2];
  Map<Integer, Integer> map = new HashMap<>();
  for (int num : nums) {
   map.put(num, map.getOrDefault(num, 0) + 1);
  }
  int i = 0;
  for (int num : map.keySet()) {
   if (map.get(num) == 1) {
    res[i++] = num;
   }
  }
  return res;
 }
}

// hashmap
// @lc code=end
