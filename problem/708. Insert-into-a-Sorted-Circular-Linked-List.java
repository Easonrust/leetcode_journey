/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
 public Node insert(Node head, int insertVal) {
  if (head == null) {
   Node newNode = new Node(insertVal);
   head = newNode;
   newNode.next = newNode;
   return head;
  }

  Node prev = head;
  Node curr = prev.next;
  boolean toInsert = false;
  do {
   if (prev.val <= insertVal && insertVal <= curr.val) {
    // Case 1
    toInsert = true;
   } else if (prev.val > curr.val) {
    // Case 2
    if (insertVal >= prev.val || insertVal <= curr.val)
     toInsert = true;
   }

   if (toInsert) {
    prev.next = new Node(insertVal, curr);
    return head;
   }

   prev = curr;
   curr = curr.next;
  } while (prev != head);

  // Case 3
  prev.next = new Node(insertVal, curr);
  return head;

 }

}

// 因为插入后要保证顺序，所以要使用前后两个指针进行判断
// case1: 插入的值大于前指针，小于后指针，此时插入两指针中间
// case2: 插入的值大于最大指针或小于最小指针，此时插在末尾

// 一圈遍历后，可能因为list中所有值相等导致没有插入
// 此时直接插入即可