/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> idxForVal;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idxForVal = new HashMap<>();
        for(int i=0; i<inorder.length; ++i){
            idxForVal.put(inorder[i], i);
        }

        TreeNode root = helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart>preEnd){
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = idxForVal.get(rootVal);
        int leftSize = rootIdx - inStart;
        root.left = helper(preorder, preStart+1, preStart+leftSize, inorder, inStart, rootIdx-1);
        root.right = helper(preorder, preStart+leftSize+1, preEnd, inorder, rootIdx+1, inEnd);
        return root;
    }
}