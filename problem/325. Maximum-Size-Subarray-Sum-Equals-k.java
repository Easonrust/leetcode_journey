class Solution {
 public int maxSubArrayLen(int[] nums, int k) {
  int[] sum = new int[nums.length + 1];
  sum[0] = 0;
  for (int i = 1; i < sum.length; ++i) {
   sum[i] = sum[i - 1] + nums[i - 1];
  }

  Map<Integer, Integer> map = new HashMap<>();
  int res = 0;
  for (int i = 0; i < sum.length; ++i) {
   if (map.containsKey(sum[i] - k)) {
    res = Math.max(res, i - map.get(sum[i] - k));
   }

   map.put(sum[i], Math.min(map.getOrDefault(sum[i], sum.length), i));
  }

  return res;
 }
}

// 前缀和 560 的变形