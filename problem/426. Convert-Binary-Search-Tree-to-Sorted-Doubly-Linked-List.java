/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
 // 记录最小的结点
 Node first = null;

 // 记录目前为止最大的结点
 Node last = null;

 public Node treeToDoublyList(Node root) {
  if (root == null) {
   return root;
  }

  inorder(root);

  last.right = first;
  first.left = last;
  return first;
 }

 public void inorder(Node node) {
  if (node == null) {
   return;
  }

  inorder(node.left);

  if (last != null) {
   last.right = node;
   node.left = last;
  } else {

   // last为null时，说明是最左下的结点，也就是最小的第一个节点
   first = node;
  }

  last = node;
  inorder(node.right);

 }
}

// 注意是二叉搜索树，所以要用inorder解决问题