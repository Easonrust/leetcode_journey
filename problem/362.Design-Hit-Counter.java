class HitCounter {
 Queue<Integer> queue;

 public HitCounter() {
  queue = new LinkedList<>();
 }

 public void hit(int timestamp) {
  queue.offer(timestamp);
 }

 public int getHits(int timestamp) {
  while (!queue.isEmpty()) {
   if (timestamp - queue.peek() >= 300) {
    queue.poll();
   } else {
    break;
   }
  }
  return queue.size();
 }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

// 没搞懂描述里面说几个hits可以几乎同时到达的意思，被迷惑了，没必要用map