class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;

    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>((o1, o2) -> (o2 - o1));
    }

    public void addNum(int num) {
        if (small.size() <= large.size()) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() < large.size()) {
            return large.peek();
        } else if (small.size() > large.size()) {
            return small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */