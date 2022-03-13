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

    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);

        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = dfs(root.left, p, q) == true ? 1 : 0;
        int right = dfs(root.right, p, q) == true ? 1 : 0;
        int mid = (root.val == p.val || root.val == q.val) == true ? 1 : 0;

        if (left + mid + right >= 2) {
            res = root;
        }

        return (left + mid + right > 0);
    }
}

// dfs
