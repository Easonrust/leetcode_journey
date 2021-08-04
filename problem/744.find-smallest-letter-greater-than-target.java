/*
 * @lc app=leetcode id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 *
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * algorithms
 * Easy (45.77%)
 * Likes:    773
 * Dislikes: 867
 * Total Accepted:    118.2K
 * Total Submissions: 258.1K
 * Testcase Example:  '["c","f","j"]\n"a"'
 *
 * Given a characters array letters that is sorted in non-decreasing order and
 * a character target, return the smallest character in the array that is
 * larger than target.
 * 
 * Note that the letters wrap around.
 * 
 * 
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is
 * 'a'.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "g"
 * Output: "j"
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "j"
 * Output: "c"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= letters.length <= 10^4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = letters[0];
        for (char letter : letters) {
            if (letter > target) {
                result = letter;
                break;
            }
        }
        return result;

    }
}
// @lc code=end
