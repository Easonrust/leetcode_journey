/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
 public int[] maxSlidingWindow(int[] nums, int k) {
  if (k == 1) {
   return nums;
  }

  int n = nums.length;
  int[] leftMax = new int[n];
  int[] rightMax = new int[n];
  int[] res = new int[n - k + 1];

  for (int i = 0; i < n; ++i) {
   if (i % k == 0) {
    leftMax[i] = nums[i];
   } else {
    leftMax[i] = Math.max(nums[i], leftMax[i - 1]);
   }
  }

  for (int i = n - 1; i >= 0; --i) {
   if ((i + 1) % k == 0 || i == n - 1) {
    rightMax[i] = nums[i];
   } else {
    rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
   }
  }

  for (int i = 0; i < n - k + 1; ++i) {
   res[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
  }
  return res;

 }
}

// dp
// 可以把序列看成一个一个k大小的块，最难处理的是块的交接处
// 这里可以用left[j] 存储第j个字符距离到离他最近的块开始处的最大值，用right[i]
// 存储第i个字符距离到离他最近的块结束处的最大值，这样两个最大值可以把一个sliding window的区域覆盖住了
// @lc code=end
