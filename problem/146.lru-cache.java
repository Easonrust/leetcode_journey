class Node {
    int key;
    int val;
    Node pre;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class DoublyList {
    Node tail;
    Node head;
    DoublyList(){
        tail = new Node(0,0);
        head = new Node(0,0);
        tail.pre = head;
        head.next = tail;
    }

    void addLast(Node node){
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    void remove(Node node){
        if(head.next==tail){
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    Node removeFirst(){
        if(head.next==tail){
            return null;
        }
        Node node = head.next;
        head.next = node.next;
        node.next.pre = head;
        return node;
    }
}


class LRUCache {
    Map<Integer, Node> map;
    DoublyList cache;
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoublyList();
        map = new HashMap<>(); 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            cache.remove(node);
            node.val = value;
            cache.addLast(node);
        }else{
            Node node = new Node(key, value);
            map.put(key, node);
            cache.addLast(node);
            if(map.size()>this.cap){
                Node first = cache.removeFirst();
                map.remove(first.key);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */