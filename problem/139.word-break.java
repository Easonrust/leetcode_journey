/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 *
 * https://leetcode.com/problems/word-break/description/
 *
 * algorithms
 * Medium (42.61%)
 * Likes:    7655
 * Dislikes: 358
 * Total Accepted:    832.7K
 * Total Submissions: 1.9M
 * Testcase Example:  '"leetcode"\n["leet","code"]'
 *
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary
 * words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in
 * the segmentation.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet
 * code".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
 public boolean wordBreak(String s, List<String> wordDict) {
  int n = s.length();
  boolean[] dp = new boolean[n + 1];
  dp[0] = true;
  for (int i = 1; i <= n; i++) {
   for (String word : wordDict) { // 对物品的迭代应该放在最里层
    int len = word.length();
    if (len <= i && word.equals(s.substring(i - len, i))) {
     dp[i] = dp[i] || dp[i - len];
    }
   }
  }
  return dp[n];
 }
}
// @lc code=end
// 求解顺序的完全背包问题，即物品按照一定的顺序放入背包中，对背包的迭代应该在对物品的迭代外面
