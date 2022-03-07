// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        int preln = 0, curlen = 1, count = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curlen++;
            } else {
                // 重新开始数另一个数字
                preln = curlen;
                curlen = 1;
            }

            // >可以把一些子串的情况包含进去
            if (preln >= curlen) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
