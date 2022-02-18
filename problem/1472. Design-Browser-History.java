class BrowserHistory {
    private Deque<String> history;
    private Deque<String> future;

    public BrowserHistory(String homepage) {
        history = new LinkedList<>();
        future = new LinkedList<>();
        history.push(homepage);
    }

    public void visit(String url) {
        history.push(url);
        future.clear();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            future.push(history.pop());
            steps--;
        }
        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && future.size() > 0) {
            history.push(future.pop());
            steps--;
        }
        return history.peek();
    }
}

// 注意currect page始终储存在history中
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
