class MyCircularQueue {

    private int[] array;
    private int count;
    private int capacity;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
        array = new int[k];
        this.capacity = k;
        this.count = 0;
        this.head = 0;
        this.tail = -1;
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            tail = (tail + 1) % capacity;
            array[tail] = value;
            count++;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            head = (head + 1) % capacity;
            count--;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        if (!isEmpty()) {
            return array[head];
        } else {
            return -1;
        }
    }

    public int Rear() {
        if (!isEmpty()) {
            return array[tail];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}

// 为了实现ring的效果，tail和head更新的时候要mod长度

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
