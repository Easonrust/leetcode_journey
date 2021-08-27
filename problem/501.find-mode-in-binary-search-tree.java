import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
 *
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (44.79%)
 * Likes:    1615
 * Dislikes: 468
 * Total Accepted:    122.7K
 * Total Submissions: 271.8K
 * Testcase Example:  '[1,null,2,2]'
 *
 * Given the root of a binary search tree (BST) with duplicates, return all the
 * mode(s) (i.e., the most frequently occurred element) in it.
 * 
 * If the tree has more than one mode, return them in any order.
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than or equal
 * to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or
 * equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,2]
 * Output: [2]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * Follow up: Could you do that without using any extra space? (Assume that the
 * implicit stack space incurred due to recursion does not count).
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

class Solution {
 private int curCnt = 1;
 private int maxCnt = 1;
 private TreeNode preNode = null;

 public int[] findMode(TreeNode root) {
  List<Integer> retList = new ArrayList<>();
  inOrder(root, retList);
  int[] ret = new int[retList.size()];
  int idx = 0;
  for (int num : retList) {
   ret[idx] = num;
   idx++;
  }
  return ret;
 }

 private void inOrder(TreeNode root, List<Integer> retList) {
  if (root == null) {
   return;
  }
  inOrder(root.left, retList);
  if (preNode != null) {
   if (preNode.val == root.val) {
    curCnt++;
   } else {
    curCnt = 1;
   }
  }
  if (curCnt > maxCnt) {
   maxCnt = curCnt;
   retList.clear();
   retList.add(root.val);
  } else if (curCnt == maxCnt) {
   retList.add(root.val);
  }
  preNode = root;
  inOrder(root.right, retList);
 }
}
// @lc code=end
// 这种和530求中序遍历临近的最小绝对值一样，都需要定义一个preNode
