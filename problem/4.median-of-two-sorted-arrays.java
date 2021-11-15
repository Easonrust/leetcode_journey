/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  int idx1 = 0;
  int idx2 = 0;
  int median1 = 0;
  int median2 = 0;
  int n1 = nums1.length;
  int n2 = nums2.length;
  for (int i = 0; i <= (n1 + n2) / 2; ++i) {
   // 在总长度为偶数时存储中间左侧的结果
   median1 = median2;

   // nums1用完了的情况
   if (idx1 == n1) {
    median2 = nums2[idx2];
    idx2++;
   } else if (idx2 == n2) {
    median2 = nums1[idx1];
    idx1++;
   } else if (nums1[idx1] < nums2[idx2]) {
    median2 = nums1[idx1];
    idx1++;
   } else {
    median2 = nums2[idx2];
    idx2++;
   }
  }

  if ((n1 + n2) % 2 == 0) {
   return (double) (median1 + median2) / 2;
  }

  return (double) median2;
 }
}

// 使用归并的思想，但是这样没有满足O(log(m+n))的时间复杂度
// @lc code=end
