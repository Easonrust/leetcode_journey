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
        TreeNode root = helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return root;
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){
        if(prestart>preend){
            return null;
        }
        int rootval = preorder[prestart];
        TreeNode root = new TreeNode(rootval);
        int idx = idxForVal.get(rootval);
        
        int leftsize = idx - instart;
        root.left = helper(preorder, inorder, prestart+1, prestart+leftsize, instart, idx-1);
        root.right = helper(preorder, inorder, prestart+leftsize+1, preend, idx+1, inend);
        return root;
    }
}