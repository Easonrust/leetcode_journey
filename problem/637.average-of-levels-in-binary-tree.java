import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
 *
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (66.79%)
 * Likes:    2300
 * Dislikes: 212
 * Total Accepted:    215.6K
 * Total Submissions: 321.8K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10^-5 of the actual
 * answer will be accepted.
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
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
 public List<Double> averageOfLevels(TreeNode root) {
  List<Double> ret = new ArrayList<>();
  Queue<TreeNode> queue = new LinkedList<>();
  queue.add(root);
  while (!queue.isEmpty()) {
   double sum = 0;
   int size = queue.size();
   for (int i = 0; i < size; ++i) {
    TreeNode node = queue.poll();
    sum += node.val;
    if (node.left != null) {
     queue.add(node.left);
    }
    if (node.right != null) {
     queue.add(node.right);
    }
   }
   ret.add((Double) sum / size);
  }
  return ret;
 }
}
// @lc code=end
// BFS