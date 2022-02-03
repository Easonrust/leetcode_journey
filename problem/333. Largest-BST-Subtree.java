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
    public int largestBSTSubtree(TreeNode root) {
        if (validBST(root)) {
            return countNodes(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.val, Math.max(findMax(root.left), findMax(root.right)));
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.val, Math.min(findMin(root.left), findMin(root.right)));
    }

    private boolean validBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (findMax(root.left) >= root.val) {
            return false;
        }

        if (findMin(root.right) <= root.val) {
            return false;
        }

        return validBST(root.left) && validBST(root.right);
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
