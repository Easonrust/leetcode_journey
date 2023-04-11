class MyQueue {
    Deque<Integer> head;
    Deque<Integer> tail;
    public MyQueue() {
        head = new LinkedList<>();
        tail = new LinkedList<>();
    }
    
    public void push(int x) {
        tail.push(x);
    }
    
    public int pop() {
        peek();
        return head.pop();
    }
    
    public int peek() {
        if(head.isEmpty()){
            while(!tail.isEmpty()){
                head.push(tail.pop());
            }
        }
        return head.peek();
    }
    
    public boolean empty() {
        return head.isEmpty()&&tail.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */