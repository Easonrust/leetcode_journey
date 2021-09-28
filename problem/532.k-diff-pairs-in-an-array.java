/*
 * @lc app=leetcode id=532 lang=java
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
class Solution {
 public int findPairs(int[] nums, int k) {
  Map<Integer, Integer> map = new HashMap<>();
  for (int num : nums) {
   map.put(num, map.getOrDefault(num, 0) + 1);
  }
  int res = 0;
  for (int key : map.keySet()) {
   if (k == 0) {
    if (map.get(key) >= 2) {
     res++;
    }
   } else {
    if (map.containsKey(key + k)) {
     res++;
    }
   }
  }
  return res;
 }
}
// @lc code=end
