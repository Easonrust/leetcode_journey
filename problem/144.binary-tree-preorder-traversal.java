import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (59.04%)
 * Likes:    2718
 * Dislikes: 97
 * Total Accepted:    709.3K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: root = [1,2]
 * Output: [1,2]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: [1,2]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
 // 递归写法
 // private List<Integer> ret;

 // public List<Integer> preorderTraversal(TreeNode root) {
 // ret = new ArrayList<>();
 // if (root == null) {
 // return ret;
 // }
 // dfs(root);
 // return ret;
 // }

 // private void dfs(TreeNode root) {
 // if (root == null) {
 // return;
 // }
 // ret.add(root.val);
 // dfs(root.left);
 // dfs(root.right);
 // }

 // 非递归写法
 public List<Integer> preorderTraversal(TreeNode root) {
  List<Integer> ret = new ArrayList<>();
  Stack<TreeNode> stack = new Stack<>();
  stack.push(root);
  while (!stack.isEmpty()) {
   TreeNode node = stack.pop();
   if (node == null) {
    continue;
   }
   ret.add(node.val);
   stack.push(node.right);
   stack.push(node.left);
  }
  return ret;
 }
}
// @lc code=end
