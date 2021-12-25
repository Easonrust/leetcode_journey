/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
 public boolean isHappy(int n) {

  Set<Integer> seen = new HashSet<>();

  while (true) {
   int temp = 0;
   while (n > 0) {
    temp += (n % 10) * (n % 10);
    n = n / 10;
   }

   if (temp == 1) {
    return true;
   }

   if (seen.contains(temp)) {
    break;
   }

   seen.add(temp);

   n = temp;
  }

  return false;
 }
}

// 注意不一定会循环到最开始的，环可能在后面存在
// @lc code=end
