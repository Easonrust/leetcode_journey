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
 List<Integer> nums;

 public int closestValue(TreeNode root, double target) {
  nums = new ArrayList<>();
  inorder(root);
  Collections.sort(nums, new Comparator<Integer>() {
   @Override
   public int compare(Integer o1, Integer o2) {
    return Math.abs(o1 - target) < Math.abs(o2 - target) ? -1 : 1;
   }
  });
  int res = nums.get(0);
  return res;
 }

 public void inorder(TreeNode root) {
  if (root == null) {
   return;
  }

  inorder(root.left);
  nums.add(root.val);
  inorder(root.right);

 }
}

// Comparator 对int处理统一用Integer，对BST进行inorder遍历得到的是升序序列
