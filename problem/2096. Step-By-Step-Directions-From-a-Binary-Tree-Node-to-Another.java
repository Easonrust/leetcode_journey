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
    TreeNode lca = null;
    String startPath;
    String destPath;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        lca = root;
        findLCA(root, startValue, destValue);
        StringBuilder sb = new StringBuilder();
        buildStartPath(sb, lca, startValue);
        buildDestPath(sb, lca, destValue);

        return startPath + destPath;
    }

    private boolean findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null) {
            return false;
        }

        int left = findLCA(root.left, startValue, destValue) ? 1 : 0;
        int right = findLCA(root.right, startValue, destValue) ? 1 : 0;
        int mid = (root.val == startValue || root.val == destValue) ? 1 : 0;
        if (left + right + mid >= 2) {
            lca = root;
        }

        return left + right + mid > 0;
    }

    private void buildDestPath(StringBuilder sb, TreeNode root, int destValue) {
        if (root == null) {
            return;
        }
        if (root.val == destValue) {
            destPath = sb.toString();
        }

        sb.append("L");
        buildDestPath(sb, root.left, destValue);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("R");
        buildDestPath(sb, root.right, destValue);
        sb.deleteCharAt(sb.length() - 1);
    }

    private void buildStartPath(StringBuilder sb, TreeNode root, int startValue) {
        if (root == null) {
            return;
        }
        if (root.val == startValue) {
            startPath = sb.toString();
        }

        sb.append("U");
        buildStartPath(sb, root.left, startValue);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("U");
        buildStartPath(sb, root.right, startValue);
        sb.deleteCharAt(sb.length() - 1);
    }
}
