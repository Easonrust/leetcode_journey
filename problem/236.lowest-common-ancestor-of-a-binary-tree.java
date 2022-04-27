/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (root.val == v1 || root.val == v2) {
            return root;
        }

        TreeNode left = find(root.left, v1, v2);
        TreeNode right = find(root.right, v1, v2);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }
        return right;
    }
}