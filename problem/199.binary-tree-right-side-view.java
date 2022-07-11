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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if(root==null){
            return res;
        }
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i=0; i<sz; ++i){
                TreeNode node = queue.removeFirst();
                
                if(node.left!=null){
                    queue.addLast(node.left);
                }
                
                if(node.right!=null){
                    queue.addLast(node.right);
                }
                
                if(i==sz-1){
                    res.add(node.val);
                }
            }
        }
        
        return res;
    }
}