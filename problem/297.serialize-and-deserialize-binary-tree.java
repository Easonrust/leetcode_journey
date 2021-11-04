/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

 // Encodes a tree to a single string.
 public String serialize(TreeNode root) {
  return serialize(root, "");
 }

 public String serialize(TreeNode root, String str) {
  if (root == null) {
   str += "null,";
  } else {
   str += String.valueOf(root.val) + ",";

   // 里面已经有+=的操作了，不要重复的+=了
   str = serialize(root.left, str);
   str = serialize(root.right, str);
  }
  return str;
 }

 // Decodes your encoded data to tree.
 public TreeNode deserialize(String data) {
  List<String> l = new ArrayList<>(Arrays.asList(data.split(",")));
  return deserialize(data, l);
 }

 public TreeNode deserialize(String data, List<String> l) {
  if (l.get(0).equals("null")) {
   l.remove(0);
   return null;
  }

  TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
  l.remove(0);
  node.left = deserialize(data, l);
  node.right = deserialize(data, l);
  return node;
 }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end
