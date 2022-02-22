/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int cnt = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return cnt;
        }
        dfs(root);
        return cnt;
    }

    private boolean dfs(TreeNode node) {
        if (node.right == null && node.left == null) {
            cnt++;
            return true;
        }

        boolean res = true;

        if (node.right != null) {
            res = dfs(node.right) && res && (node.right.val == node.val);
        }

        if (node.left != null) {
            res = dfs(node.left) && res && (node.left.val == node.val);
        }

        if (res) {
            cnt++;
        }

        return res;
    }
}

// dfs
