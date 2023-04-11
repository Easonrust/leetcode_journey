class MyStack {
    Queue<Integer> q;
    int topElem;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        topElem = x;
    }
    
    public int pop() {
        int sz = q.size();
        while(sz>2){
            q.offer(q.poll());
            sz--;
        }
        topElem = q.poll();
        q.offer(topElem);
        return q.poll();
    }
    
    public int top() {
        return topElem;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */