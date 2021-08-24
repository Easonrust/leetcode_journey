import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 *
 * https://leetcode.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (49.38%)
 * Likes:    7071
 * Dislikes: 183
 * Total Accepted:    978.8K
 * Total Submissions: 2M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Could you solve it both recursively and iteratively?
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
 public boolean isSymmetric(TreeNode root) {
  if (root == null) {
   return false;
  }
  return isSymmetricAsRoot(root.left, root.right);
 }

 public boolean isSymmetricAsRoot(TreeNode t1, TreeNode t2) {
  if (t1 == null && t2 == null) {
   return true;
  } else if (t1 == null || t2 == null) {
   return false;
  }
  if (t1.val != t2.val) {
   return false;
  }
  return isSymmetricAsRoot(t1.left, t2.right) && isSymmetricAsRoot(t1.right, t2.left);

 }
}
// @lc code=end
// 和子树包含问题的树比较方式相似
