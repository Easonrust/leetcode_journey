import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Hard (33.03%)
 * Likes:    5668
 * Dislikes: 1471
 * Total Accepted:    617.5K
 * Total Submissions: 1.9M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * A transformation sequence from word beginWord to word endWord using a
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... ->
 * sk such that:
 * 
 * 
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
 * to be in wordList.
 * sk == endWord
 * 
 * 
 * Given two words, beginWord and endWord, and a dictionary wordList, return
 * the number of words in the shortest transformation sequence from beginWord
 * to endWord, or 0 if no such sequence exists.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot"
 * -> "dog" -> cog", which is 5 words long.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no
 * valid transformation sequence.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English
 * letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1, end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private boolean isConnected(String s1, String s2) {
        int diffCnt = 0, N = s1.length();
        for (int i = 0; i < N; i++) {
            if (diffCnt > 1) {
                break;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; ++j) {
                if (isConnected(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] marked = new boolean[graphic.length];
        marked[start] = true;
        int pathLength = 1;
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                for (int nur : graphic[cur]) {
                    if (marked[nur]) {
                        continue;
                    }
                    if (nur == end) {
                        return pathLength;
                    }
                    marked[nur] = true;
                    queue.add(nur);
                }
            }
        }
        return 0;
    }
}
// @lc code=end
