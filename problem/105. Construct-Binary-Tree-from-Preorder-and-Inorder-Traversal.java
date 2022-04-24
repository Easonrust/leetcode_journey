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
    Map<Integer, Integer> inIdxForVal;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inIdxForVal = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inIdxForVal.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootInIdx = inIdxForVal.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftSize = rootInIdx - 1 - inStart;

        root.left = helper(preorder, inorder, preStart + 1, preStart + 1 + leftSize, inStart, rootInIdx - 1);
        root.right = helper(preorder, inorder, preStart + 1 + leftSize + 1, preEnd, rootInIdx + 1, inEnd);
        return root;
    }
}
