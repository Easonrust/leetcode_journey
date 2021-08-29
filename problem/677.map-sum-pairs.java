/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 *
 * https://leetcode.com/problems/map-sum-pairs/description/
 *
 * algorithms
 * Medium (54.31%)
 * Likes:    990
 * Dislikes: 112
 * Total Accepted:    75.1K
 * Total Submissions: 131.8K
 * Testcase Example:  '["MapSum","insert","sum","insert","sum"]\n' +
  '[[],["apple",3],["ap"],["app",2],["ap"]]'
 *
 * Design a map that allows you to do the following:
 * 
 * 
 * Maps a string key to a given value.
 * Returns the sum of the values that have a key with a prefix equal to a given
 * string.
 * 
 * 
 * Implement the MapSum class:
 * 
 * 
 * MapSum() Initializes the MapSum object.
 * void insert(String key, int val) Inserts the key-val pair into the map. If
 * the key already existed, the original key-value pair will be overridden to
 * the new one.
 * int sum(string prefix) Returns the sum of all the pairs' value whose key
 * starts with the prefix.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * Output
 * [null, null, 3, null, 5]
 * 
 * Explanation
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);  
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);    
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= key.length, prefix.length <= 50
 * key and prefix consist of only lowercase English letters.
 * 1 <= val <= 1000
 * At most 50 calls will be made to insert and sum.
 * 
 * 
 */

// @lc code=start
class MapSum {

 private class Node {

  // 每个结点会有26个字符域
  Node[] childs = new Node[26];
  int value;
 }

 private Node root = new Node();

 /** Initialize your data structure here. */
 public MapSum() {

 }

 public void insert(String key, int val) {
  insert(key, root, val);
 }

 private void insert(String key, Node node, int val) {
  if (node == null) {
   return;
  }
  if (key.length() == 0) {
   node.value = val;
   return;
  }
  int index = indexForChar(key.charAt(0));
  if (node.childs[index] == null) {
   node.childs[index] = new Node();
  }
  insert(key.substring(1), node.childs[index], val);
 }

 public int sum(String prefix) {
  return sum(prefix, root);

 }

 private int sum(String prefix, Node node) {
  if (node == null) {
   return 0;
  }
  if (prefix.length() != 0) {
   int index = indexForChar(prefix.charAt(0));
   return sum(prefix.substring(1), node.childs[index]);
  }

  // 此时prefix为0，求和prefix为0的node下面所有的child
  int sum = node.value;
  for (Node child : node.childs) {
   sum += sum(prefix, child);
  }
  return sum;
 }

 // 对字符进行编号，字母a为0，题目中均为小写的英文字符
 private int indexForChar(char c) {
  return c - 'a';
 }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// @lc code=end
