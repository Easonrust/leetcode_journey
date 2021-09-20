import java.util.HashSet;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
 public int lengthOfLongestSubstring(String s) {
  int res = 0;
  Set<Character> window = new HashSet<>();
  for (int i = 0, j = 0; i < s.length(); ++i) {
   char c = s.charAt(i);
   while (window.contains(c)) {
    window.remove(s.charAt(j));
    j++;
   }
   window.add(c);
   res = Math.max(res, i - j + 1);
  }
  return res;
 }
}
// @lc code=end
// “滑动窗口 + 哈希表”。

// 定义一个哈希表记录当前窗口内出现的字符，i、j 分别表示不重复子串的结束位置和开始位置，res 表示无重复字符子串的最大长度。

// 遍历 i，若 [j, i - 1] 窗口内存在 s[i]，则 j 循环向右移动，更新哈希表，直至 [j, i - 1] 窗口不存在 s[i]，循环结束。将
// s[i] 加入哈希表中，此时 [j, i] 窗口内不含重复元素，更新 res 的最大值：res = max(res, i - j + 1)。

// 最后返回 res 即可。

// 右指针j是在寻找一个可行解，左指针i是在优化窗口使其符合条件
// 滑动窗口的定义可以查看https://www.cnblogs.com/huansky/p/13488234.html
