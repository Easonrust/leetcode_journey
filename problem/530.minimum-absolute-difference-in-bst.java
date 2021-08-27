import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (55.47%)
 * Likes:    1504
 * Dislikes: 102
 * Total Accepted:    127.1K
 * Total Submissions: 228.7K
 * Testcase Example:  '[4,2,6,1,3]'
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute
 * difference between the values of any two different nodes in the tree.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [4,2,6,1,3]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [2, 10^4].
 * 0 <= Node.val <= 10^5
 * 
 * 
 * 
 * Note: This question is the same as 783:
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
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
 private int minDiff = Integer.MAX_VALUE;
 private TreeNode preNode = null;

 public int getMinimumDifference(TreeNode root) {
  inOrder(root);
  return minDiff;
 }

 private void inOrder(TreeNode root) {
  if (root == null) {
   return;
  }
  inOrder(root.left);
  if (preNode != null) {
   minDiff = Math.min(minDiff, root.val - preNode.val);
  }
  preNode = root;
  inOrder(root.right);
 }
}

// @lc code=end
