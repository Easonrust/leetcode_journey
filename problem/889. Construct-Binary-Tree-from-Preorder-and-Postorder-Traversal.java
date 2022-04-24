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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        idxForVal = new HashMap<>();
        for (int i = 0; i < postorder.length; ++i) {
            idxForVal.put(postorder[i], i);
        }
        return helper(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftVal = preorder[preStart + 1];
        int leftIdx = idxForVal.get(leftVal);
        int leftSize = leftIdx - postStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, postorder, preStart + 1, preStart + 1 + leftSize, postStart, leftIdx);
        root.right = helper(preorder, postorder, preStart + 1 + leftSize + 1, preEnd, leftIdx + 1, postEnd - 1);
        return root;
    }
}