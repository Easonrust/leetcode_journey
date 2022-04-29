
class LRUCache {
    class DNode {
        int key, val;
        DNode pre;
        DNode next;

        DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        DNode head;
        DNode tail;
        int size;

        DoubleList() {
            head = new DNode(0, 0);
            tail = new DNode(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        public void addLast(DNode node) {
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
            size++;
        }

        public void remove(DNode node) {
            if (size == 0) {
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public DNode removeFirst() {
            if (size == 0) {
                return null;
            }
            DNode node = head.next;
            head.next = node.next;
            node.next.pre = head;
            size--;
            return node;
        }
    }

    int capacity;
    Map<Integer, DNode> map;
    DoubleList dList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dList = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DNode node = map.get(key);
        dList.remove(node);
        dList.addLast(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.val = value;
            dList.remove(node);
            dList.addLast(node);
            map.put(key, node);
        } else {
            if (dList.size < this.capacity) {
                DNode node = new DNode(key, value);
                dList.addLast(node);
                map.put(key, node);
            } else {
                DNode first = dList.removeFirst();
                map.remove(first.key);
                DNode node = new DNode(key, value);
                dList.addLast(node);
                map.put(key, node);
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