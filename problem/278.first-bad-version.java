/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 *
 * https://leetcode.com/problems/first-bad-version/description/
 *
 * algorithms
 * Easy (38.62%)
 * Likes:    2513
 * Dislikes: 905
 * Total Accepted:    608.3K
 * Total Submissions: 1.6M
 * Testcase Example:  '5\n4'
 *
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all
 * the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the
 * first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which returns whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, bad = 1
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= bad <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        // int l = 1;
        // for (int i = 1; i <= n; i++) {
        // if (isBadVersion(i)) {
        // return i;
        // }
        // }
        return l;
    }
}
// @lc code=end
// 注意顺序查找会超时
