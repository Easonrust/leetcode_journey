// @lc code=start
class Solution {
 public int jump(int[] nums) {
  int mx = 0, end = 0, steps = 0;
  for (int i = 0; i < nums.length - 1; ++i) {
   mx = Math.max(mx, i + nums[i]);
   if (i == end) {
    steps++;
    end = mx;
   }
  }
  return steps;
 }
}
// @lc code=end
