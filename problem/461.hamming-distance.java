/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
 public int hammingDistance(int x, int y) {
  return Integer.bitCount(x ^ y);
 }
}

// ^表示异或运算 >>n 算数右移，除以2的n次方
// @lc code=end
