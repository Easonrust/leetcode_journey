/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
 public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
  List<Interval> res = new ArrayList<>();

  PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<>() {
   @Override
   public int compare(Interval o1, Interval o2) {
    return o1.start - o2.start;
   }
  });

  for (List<Interval> list : schedule) {
   for (Interval interval : list) {
    pq.offer(interval);
   }
  }

  int end = pq.poll().end;
  while (!pq.isEmpty()) {
   if (end < pq.peek().start) {
    res.add(new Interval(end, pq.peek().start));
    end = pq.poll().end;
   } else {
    if (end < pq.peek().end) {
     end = pq.poll().end;
    } else {
     pq.poll();
    }
   }
  }

  return res;

 }
}

// greedy，使用堆将所有的区间存起来，按start time排序
