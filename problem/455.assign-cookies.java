import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 *
 * https://leetcode.com/problems/assign-cookies/description/
 *
 * algorithms
 * Easy (50.41%)
 * Likes:    968
 * Dislikes: 133
 * Total Accepted:    131.5K
 * Total Submissions: 260.7K
 * Testcase Example:  '[1,2,3]\n[1,1]'
 *
 * Assume you are an awesome parent and want to give your children some
 * cookies. But, you should give each child at most one cookie.
 * 
 * Each child i has a greed factor g[i], which is the minimum size of a cookie
 * that the child will be content with; and each cookie j has a size s[j]. If
 * s[j] >= g[i], we can assign the cookie j to the child i, and the child i
 * will be content. Your goal is to maximize the number of your content
 * children and output the maximum number.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3
 * children are 1, 2, 3. 
 * And even though you have 2 cookies, since their size is both 1, you could
 * only make the child whose greed factor is 1 content.
 * You need to output 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2
 * children are 1, 2. 
 * You have 3 cookies and their sizes are big enough to gratify all of the
 * children, 
 * You need to output 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= g.length <= 3 * 10^4
 * 0 <= s.length <= 3 * 10^4
 * 1 <= g[i], s[j] <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
 public int findContentChildren(int[] g, int[] s) {
  if (g == null || s == null) {
   return 0;
  }
  Arrays.sort(g);
  Arrays.sort(s);
  int gi = 0, si = 0;
  while (gi < g.length && si < s.length) {
   if (s[si] >= g[gi]) {
    gi++;
   }
   si++;
  }
  return gi;
 }
}
// @lc code=end
// 贪心算法
// 优先使用较小的饼干满足欲望较小的孩子
