/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {

 PriorityQueue<Integer> maxHeap;
 PriorityQueue<Integer> minHeap;

 public MedianFinder() {
  maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  minHeap = new PriorityQueue<>();
 }

 public void addNum(int num) {
  // maxHeap.add(num);
  // minHeap.add(maxHeap.poll());

  minHeap.add(num);
  maxHeap.add(minHeap.poll());

  if (maxHeap.size() > minHeap.size()) {
   minHeap.add(maxHeap.poll());
  }
 }

 public double findMedian() {

  // 注意这里用peek，不要用poll，因为函数可能被call很多次

  if (maxHeap.size() == minHeap.size()) {
   return (maxHeap.peek() + minHeap.peek()) / 2.0;
  } else {
   return minHeap.peek();
  }
 }
}

// maxHeap中存左半部分的值，minHeap 中存右半部分的值

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
