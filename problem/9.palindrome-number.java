// @lc code=start
class Solution {
 public boolean isPalindrome(int x) {
  if (x == 0) {
   return true;
  }
  if (x < 0 || x % 10 == 0) {
   return false;
  }
  int right = 0;

  // 这部分是将数字分成左右两部分，比如3223，分成32和23，再将23翻转成32
  while (x > right) {
   right = right * 10 + x % 10;
   x /= 10;
  }

  // 需要考虑数字为奇数长度的情况，即right/10
  return x == right || x == right / 10;
 }
}
// @lc code=end
