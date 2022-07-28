/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while(a!=b){
            if(a.parent!=null){
                a = a.parent;
            }else{
                a = q;
            }
            
            if(b.parent!=null){
                b = b.parent;
            }else{
                b = p;
            }
        }
        
        return a;
    }
}

//相交链表