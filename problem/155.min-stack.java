class MinStack {
    Deque<Integer> dataStack;
    Deque<Integer> minStack;
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        dataStack.push(val);
        if(minStack.isEmpty()||minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(minStack.peek().equals(dataStack.peek())){
            minStack.pop();
        }
        dataStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */