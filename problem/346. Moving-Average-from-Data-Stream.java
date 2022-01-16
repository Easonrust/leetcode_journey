class MovingAverage {
 Queue<Integer> window;
 int size;
 int sum;

 public MovingAverage(int size) {
  this.window = new LinkedList<>();
  this.size = size;
  sum = 0;
 }

 public double next(int val) {
  window.offer(val);
  sum += val;
  if (window.size() > size) {
   sum -= window.poll();
  }
  return (double) sum / (double) window.size();
 }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

// queue