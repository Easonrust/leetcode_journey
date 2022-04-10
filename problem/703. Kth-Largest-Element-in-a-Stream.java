class KthLargest {
    private static int K;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        while (pq.size() > K) {
            pq.poll();
        }
        return pq.peek();
    }
}
// 保证堆的大小一直为k，则堆顶的元素就是第K大的元素
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
