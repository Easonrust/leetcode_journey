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
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return recursion(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode recursion(int[] preorder, int low, int high) {
        if (idx == preorder.length) {
            return null;
        }
        int val = preorder[idx];

        // 检查是否可以放在当前位置，可以的话idx才会++
        if (val < low || val > high)
            return null;
        idx++;
        TreeNode node = new TreeNode(val);
        node.left = recursion(preorder, low, val);
        node.right = recursion(preorder, val, high);
        return node;
    }
}
