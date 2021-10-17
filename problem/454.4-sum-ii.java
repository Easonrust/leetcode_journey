/*
 * @lc app=leetcode id=454 lang=java
 *
 * [454] 4Sum II
 */

// @lc code=start
class Solution {
 public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
  int n = nums1.length;
  int res = 0;
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < n; ++i) {
   int a = nums1[i];
   for (int j = 0; j < n; ++j) {
    int b = nums2[j];
    map.put(a + b, map.getOrDefault(a + b, 0) + 1);
   }
  }
  for (int i = 0; i < n; ++i) {
   int c = nums3[i];
   for (int j = 0; j < n; ++j) {
    int d = nums4[j];
    if (map.containsKey(-(c + d))) {
     res += map.get(-(c + d));
    }
   }
  }
  return res;
 }
}

// 使用hashmap可以把这种n4的问题缩小到n2
// @lc code=end
