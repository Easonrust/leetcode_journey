import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 *
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * algorithms
 * Medium (52.20%)
 * Likes:    4627
 * Dislikes: 74
 * Total Accepted:    227.8K
 * Total Submissions: 435.6K
 * Testcase Example:  '[3,2,3,null,3,null,1]'
 *
 * The thief has found himself a new place for his thievery again. There is
 * only one entrance to this area, called root.
 * 
 * Besides the root, each house has one and only one parent house. After a
 * tour, the smart thief realized that all houses in this place form a binary
 * tree. It will automatically contact the police if two directly-linked houses
 * were broken into on the same night.
 * 
 * Given the root of the binary tree, return the maximum amount of money the
 * thief can rob without alerting the police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * 0 <= Node.val <= 10^4
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 private Map<TreeNode, Integer> cache = new HashMap<>();

 public int rob(TreeNode root) {
  if (root == null) {
   return 0;
  }
  if (cache.containsKey(root)) {
   return cache.get(root);
  }
  int val1 = root.val;
  if (root.left != null) {
   val1 += rob(root.left.left) + rob(root.left.right);
  }
  if (root.right != null) {
   val1 += rob(root.right.left) + rob(root.right.right);
  }
  int val2 = rob(root.left) + rob(root.right);
  int val = Math.max(val1, val2);
  cache.put(root, val);
  return val;
 }
}
// @lc code=end
// 如果不加一个map存储值的话，会因为大量重复的计算导致超时
