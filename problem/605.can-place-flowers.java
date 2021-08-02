/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 *
 * https://leetcode.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (31.58%)
 * Likes:    1647
 * Dislikes: 505
 * Total Accepted:    189.1K
 * Total Submissions: 598.6K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * You have a long flowerbed in which some of the plots are planted, and some
 * are not. However, flowers cannot be planted in adjacent plots.
 * 
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty
 * and 1 means not empty, and an integer n, return if n new flowers can be
 * planted in the flowerbed without violating the no-adjacent-flowers rule.
 * 
 * 
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int max = 0;
        if (flowerbed.length < 3) {
            for (int flower : flowerbed) {
                if (flower == 1) {
                    return max >= n;
                }
            }
            max = 1;
        } else {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                max++;
                flowerbed[0] = 1;
            }
            for (int i = 1; i < flowerbed.length - 1; ++i) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    max++;
                    flowerbed[i] = 1;
                }
            }
            if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
                max++;
                flowerbed[flowerbed.length - 1] = 1;
            }
        }
        return max >= n;
    }
}
// @lc code=end
