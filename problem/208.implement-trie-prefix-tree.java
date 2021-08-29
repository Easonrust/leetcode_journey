/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (53.94%)
 * Likes:    5143
 * Dislikes: 77
 * Total Accepted:    453.1K
 * Total Submissions: 833.2K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 10^4 calls in total will be made to insert, search, and
 * startsWith.
 * 
 * 
 */

// @lc code=start
class Trie {

 private class Node {

  // 每个结点会有26个字符域
  Node[] childs = new Node[26];
  boolean isLeaf;
 }

 private Node root = new Node();

 /** Initialize your data structure here. */
 public Trie() {
 }

 /** Inserts a word into the trie. */
 public void insert(String word) {
  insert(word, root);
 }

 // 函数的重载
 private void insert(String word, Node node) {
  if (node == null) {
   return;
  }
  if (word.length() == 0) {
   node.isLeaf = true;
   return;
  }
  int index = indexForChar(word.charAt(0));
  if (node.childs[index] == null) {
   node.childs[index] = new Node();
  }
  insert(word.substring(1), node.childs[index]);
 }

 /** Returns if the word is in the trie. */
 public boolean search(String word) {
  return search(word, root);
 }

 // 函数的重载
 private boolean search(String word, Node node) {
  if (node == null) {
   return false;
  }
  if (word.length() == 0) {
   return node.isLeaf;
  }
  int index = indexForChar(word.charAt(0));
  return search(word.substring(1), node.childs[index]);
 }

 /**
  * Returns if there is any word in the trie that starts with the given prefix.
  */
 public boolean startsWith(String prefix) {
  return startsWith(prefix, root);
 }

 private boolean startsWith(String prefix, Node node) {
  if (node == null) {
   return false;
  }
  if (prefix.length() == 0) {
   return true;
  }
  int index = indexForChar(prefix.charAt(0));
  return startsWith(prefix.substring(1), node.childs[index]);
 }

 // 对字符进行编号，字母a为0，题目中均为小写的英文字符
 private int indexForChar(char c) {
  return c - 'a';
 }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end

// 题目要求实现类时，可以使用重载这一工具来实现
