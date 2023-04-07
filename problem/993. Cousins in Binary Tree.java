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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Set<Integer> set = new HashSet<>();
        set.add(x);
        set.add(y);
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i=0; i<sz; ++i){
                TreeNode cur = q.poll();
                if(cur.val==x){
                    set.remove(x);
                }
                if(cur.val==y){
                    set.remove(y);
                }
                if(cur.left!=null&&cur.right!=null){
                    if(cur.left.val==x&&cur.right.val==y){
                        return false;
                    }
                    if(cur.left.val==y&&cur.right.val==x){
                        return false;
                    }
                }
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            if(set.size()==1){
                return false;
            }
            if(set.size()==0){
                return true;
            }
        }
        return set.size()==0;
    }
}