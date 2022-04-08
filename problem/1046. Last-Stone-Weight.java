class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            if (first != second) {
                pq.add(Math.abs(first - second));
            }
        }

        if (pq.size() == 0) {
            return 0;
        }
        return pq.poll();
    }
}
