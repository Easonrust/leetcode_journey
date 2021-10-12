/*
 * @lc app=leetcode id=1481 lang=java
 *
 * [1481] Least Number of Unique Integers after K Removals
 */

// @lc code=start
class Solution {
 public int findLeastNumOfUniqueInts(int[] arr, int k) {
  Map<Integer, Integer> map = new HashMap<>();
  for (int num : arr) {
   map.put(num, map.getOrDefault(num, 0) + 1);
  }

  List<Integer> values = new ArrayList<>(map.values());
  Collections.sort(values);
  for (int i = 0; i < values.size() && k > 0; ++i) {
   if (values.get(i) <= k) {
    k -= values.get(i);
    values.set(i, 0);
   } else {
    k = 0;
    values.set(i, values.get(i) - k);
   }
  }
  int res = 0;
  for (int val : values) {
   if (val != 0) {
    res++;
   }
  }
  return res;
 }
}
// @lc code=end
// hashmap 解题
