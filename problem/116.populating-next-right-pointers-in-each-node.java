import java.util.ArrayDeque;
import java.util.Deque;

import jdk.internal.jimage.ImageReader.Node;

/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
 public Node connect(Node root) {
  if (root == null) {
   return root;
  }
  if (root.left == null && root.right == null) {
   return root;
  }
  Deque<Node> queue = new ArrayDeque<>();
  queue.offer(root);
  while (!queue.isEmpty()) {
   Node cur = null;
   int size = queue.size();
   while (size-- > 0) {
    Node node = queue.poll();
    if (node.right != null) {
     queue.offer(node.right);
    }
    if (node.left != null) {
     queue.offer(node.left);
    }
    node.next = cur;
    cur = node;
   }
  }
  return root;
 }
}
// @lc code=end
// 对树进行从右向左的层次遍历即可
