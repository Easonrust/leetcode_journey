/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode list;
    int size;
    public Solution(ListNode head) {
        list = head;
        size = 0;
        ListNode dummy = head;
        while(dummy!=null){
            size++;
            dummy = dummy.next;
        }
    }
    
    public int getRandom() {
        Random r = new Random();
        int choice = r.nextInt(size);
        ListNode dummy = list;
        while(choice!=0){
            dummy = dummy.next;
            choice--;
        }
        return dummy.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */