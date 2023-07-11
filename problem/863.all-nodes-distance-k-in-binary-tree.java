/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParents(root);
        findNodes(target, new TreeNode(-1), 0, k);
        return ans;
    }

    private void findParents(TreeNode node) {
        if(node.left!=null){
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if(node.right!=null){
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    private void findNodes(TreeNode node, TreeNode from, int depth, int k) {
        if(depth==k){
            ans.add(node.val);
        }

        if(node.left!=null&&node.left.val!=from.val){
            findNodes(node.left, node, depth+1, k);
        }

        if(node.right!=null&&node.right.val!=from.val){
            findNodes(node.right, node, depth+1, k);
        }

        if(parents.containsKey(node.val)&&parents.get(node.val).val!=from.val){
            findNodes(parents.get(node.val), node, depth+1, k);
        }
    }
}