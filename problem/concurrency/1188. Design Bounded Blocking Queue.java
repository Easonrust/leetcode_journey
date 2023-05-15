class BoundedBlockingQueue {
    Semaphore empty, full, mutex;
    Deque<Integer> q;
    public BoundedBlockingQueue(int capacity) {
        empty = new Semaphore(0);
        mutex = new Semaphore(1);
        full = new Semaphore(capacity);
        q = new LinkedList<>();
    }
    
    public void enqueue(int element) throws InterruptedException {
        full.acquire();
        mutex.acquire();
        q.addFirst(element);
        mutex.release();
        empty.release();
    }
    
    public int dequeue() throws InterruptedException {
        empty.acquire();
        mutex.acquire();
        int ele = q.removeLast();
        mutex.release();
        full.release();
        return ele;
    }
    
    public int size() {
        return q.size();
    }
}