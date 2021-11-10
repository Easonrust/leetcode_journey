/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
 class DNode {
  int val;
  int key;
  DNode pre;
  DNode next;
 }

 DNode head;
 DNode tail;

 public void addNode(DNode node) {
  node.pre = head;
  node.next = head.next;
  head.next.pre = node;
  head.next = node;
 }

 public void removeNode(DNode node) {
  node.pre.next = node.next;
  node.next.pre = node.pre;
 }

 public void moveToHead(DNode node) {
  removeNode(node);
  addNode(node);
 }

 public int popTail() {
  DNode node = tail.pre;
  removeNode(node);
  return node.key;
 }

 // 定义一个双向链表，这样可以在任何位置很方便地删除和添加node

 Map<Integer, DNode> nodeForKey;
 int c;
 int s;

 public LRUCache(int capacity) {
  nodeForKey = new HashMap<>();
  c = capacity;
  s = 0;
  head = new DNode();
  tail = new DNode();
  head.pre = null;
  head.next = tail;
  tail.pre = head;
  tail.next = null;
 }

 public int get(int key) {
  if (!nodeForKey.containsKey(key)) {
   return -1;
  }
  DNode node = nodeForKey.get(key);
  moveToHead(node);
  return node.val;
 }

 public void put(int key, int value) {
  if (nodeForKey.containsKey(key)) {
   DNode node = nodeForKey.get(key);
   node.val = value;
   moveToHead(node);
  } else {
   if (s == c) {
    int k = popTail();
    nodeForKey.remove(k);
    s--;
   }
   DNode node = new DNode();
   node.key = key;
   node.val = value;
   addNode(node);
   nodeForKey.put(key, node);
   s++;
  }
 }
}

// 使用双向链表和hashmap实现，高频必考

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
