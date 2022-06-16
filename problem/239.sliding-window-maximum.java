class Solution {
    class MonotonicQueue {
        Deque<Integer> list = new LinkedList<>();

        public MonotonicQueue() {
        }

        public void push(int n) {
            while (!list.isEmpty() && list.getLast() < n) {
                list.removeLast();
            }
            list.addLast(n);
        }

        public void pop(int n) {
            if (list.getFirst() == n) {
                list.removeFirst();
            }
        }

        public int max() {
            return list.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i < k - 1) {
                mq.push(nums[i]);
            } else {
                mq.push(nums[i]);
                res.add(mq.max());
                mq.pop(nums[i - k + 1]);
            }
        }

        int[] resArr = new int[res.size()];
        for (int i = 0; i < resArr.length; ++i) {
            resArr[i] = res.get(i);
        }

        return resArr;
    }
}