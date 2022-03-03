// @lc code=start
class Solution {
 public int removeDuplicates(int[] nums) {
  int cnt = 0, n = nums.length;
  for (int i = 1; i < n; ++i) {
   if (nums[i] == nums[i - 1]) {
    cnt++;
   } else {

    // 将不重复的即没有出现过的数字提到前面
    nums[i - cnt] = nums[i];
   }
  }
  return n - cnt;
 }
}
// @lc code=end
// 注意本题中的cnt是所有的数字的重复次数累加只和
