import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (78.26%)
 * Likes:    5110
 * Dislikes: 207
 * Total Accepted:    276K
 * Total Submissions: 352.7K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * 
 * Return a list of integers representing the size of these parts.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
 * splits s into less parts.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            lastIndexOfChar[char2index(s.charAt(i))] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < s.length() && i <= lastIndex; i++) {
                if (lastIndex < lastIndexOfChar[char2index(s.charAt(i))]) {
                    lastIndex = lastIndexOfChar[char2index(s.charAt(i))];
                }
            }
            partition.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;

        }
        return partition;
    }

    private int char2index(char c) {
        return c - 'a';
    }
}
// @lc code=end
// 注意循环中lastIndex初始化的问题，问题为每次都去求真正的lastIndex
