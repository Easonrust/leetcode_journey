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
    Map<Integer, Integer> idxForVal;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idxForVal = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            idxForVal.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIdx = idxForVal.get(rootVal);

        int rightSize = inEnd - (rootIdx + 1);

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, postorder, inStart, rootIdx - 1, postStart, postEnd - 1 - rightSize - 1);
        root.right = helper(inorder, postorder, rootIdx + 1, inEnd, postEnd - 1 - rightSize, postEnd - 1);
        return root;
    }
}
