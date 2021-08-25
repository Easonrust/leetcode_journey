import java.util.Collection;
import java.util.Collections;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (59.61%)
 * Likes:    2994
 * Dislikes: 121
 * Total Accepted:    542.4K
 * Total Submissions: 902.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the postorder traversal of its
 * nodes' values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * Output: [2,1]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: root = [1,null,2]
 * Output: [2,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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

 // public List<Integer> postorderTraversal(TreeNode root) {
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
 // dfs(root.left);
 // dfs(root.right);
 // ret.add(root.val);
 // }

 // 非递归写法
 public List<Integer> postorderTraversal(TreeNode root) {
  List<Integer> ret = new ArrayList<>();
  Stack<TreeNode> stack = new Stack<>();
  stack.push(root);
  while (!stack.isEmpty()) {
   TreeNode node = stack.pop();
   if (node == null) {
    continue;
   }
   ret.add(node.val);
   stack.push(node.left);
   stack.push(node.right);
  }
  Collections.reverse(ret);
  return ret;
 }
}
// @lc code=end
// 在非递归写法中，调整进栈顺序，可以使前序遍历和后序遍历完全相反
