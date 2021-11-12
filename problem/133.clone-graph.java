/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

 // class Node {
 // public int val;
 // public List<Node> neighbors;
 // public Node() {
 // val = 0;
 // neighbors = new ArrayList<Node>();
 // }
 // public Node(int _val) {
 // val = _val;
 // neighbors = new ArrayList<Node>();
 // }
 // public Node(int _val, ArrayList<Node> _neighbors) {
 // val = _val;
 // neighbors = _neighbors;
 // }
 // }
 Map<Node, Node> visited = new HashMap<>();

 public Node cloneGraph(Node node) {
  if (node == null) {
   return node;
  }
  if (visited.containsKey(node)) {
   return visited.get(node);
  }
  Node newNode = new Node(node.val);
  visited.put(node, newNode);
  for (Node neighbor : node.neighbors) {
   Node newNeighbor = cloneGraph(neighbor);
   newNode.neighbors.add(newNeighbor);
  }

  return newNode;
 }

}

// 这种dfs问题，除了可以用数组mark是否被访问过之外，还可以用hashmap的containskey来判断是否被访问过
// @lc code=end
