/*
 * @lc app=leetcode id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 */

// @lc code=start
class Solution {
 public int subarraySum(int[] nums, int k) {
  int res = 0;
  int[] sum = new int[nums.length + 1];
  sum[0] = 0;

  for (int i = 1; i < sum.length; ++i) {
   sum[i] = sum[i - 1] + nums[i - 1];
  }

  Map<Integer, Integer> map = new HashMap<>();

  for (int i = 0; i < sum.length; ++i) {
   if (map.containsKey(sum[i] - k)) {
    res += map.get(sum[i] - k);
   }
   map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
  }

  return res;
 }
}

// 前缀和prefix sum, sum[i]-sum[j]=sum[j:i]
// 如果map中存在sum[j]=sum[i]-k的话, 则sum[j:i]=k，前缀和个数加上sum[j]的个数
// @lc code=end
