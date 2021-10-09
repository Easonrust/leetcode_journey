/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
 List<Integer> ans;
 TreeNode target;
 int K;

 public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
  ans = new LinkedList();
  this.target = target;
  this.K = K;
  dfs(root);
  return ans;
 }

 // Return vertex distance from node to target if exists, else -1
 // Vertex distance: the number of vertices on the path from node to target
 public int dfs(TreeNode node) {
  if (node == null)
   return -1;
  else if (node == target) {
   subtree_add(node, 0);
   return 1;
  } else {
   int L = dfs(node.left), R = dfs(node.right);
   if (L != -1) {
    if (L == K)
     ans.add(node.val);
    subtree_add(node.right, L + 1);
    return L + 1;
   } else if (R != -1) {
    if (R == K)
     ans.add(node.val);
    subtree_add(node.left, R + 1);
    return R + 1;
   } else {
    return -1;
   }
  }
 }

 // Add all nodes 'K - dist' from the node to answer.
 public void subtree_add(TreeNode node, int dist) {
  if (node == null)
   return;
  if (dist == K)
   ans.add(node.val);
  else {
   subtree_add(node.left, dist + 1);
   subtree_add(node.right, dist + 1);
  }
 }
}
// @lc code=end
// From root, say the target node is at depth 3 in the left branch. It means
// that any nodes that are distance K - 3 in the right branch should be added to
// the answer.
