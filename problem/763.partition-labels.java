import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 *
 * https://leetcode.com/problems/partition-labels/description/
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
