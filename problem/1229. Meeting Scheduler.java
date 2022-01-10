class Solution {
 public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
  Arrays.sort(slots1, new Comparator<>() {
   public int compare(int[] o1, int[] o2) {
    return o1[0] - o2[0];
   }
  });

  Arrays.sort(slots2, new Comparator<>() {
   public int compare(int[] o1, int[] o2) {
    return o1[0] - o2[0];
   }
  });

  List<Integer> res = new ArrayList<>();
  int m = slots1.length;
  int n = slots2.length;
  int first = 0;
  int second = 0;
  while (first < m && second < n) {
   int[] slot1 = slots1[first];
   int[] slot2 = slots2[second];
   int start1 = slot1[0];
   int end1 = slot1[1];
   int start2 = slot2[0];
   int end2 = slot2[1];

   int start = Math.max(start1, start2);
   int end = Math.min(end1, end2);

   if (end - start >= duration) {
    res.add(start);
    res.add(start + duration);
    break;
   }

   if (end1 < end2) {
    first++;
   } else {
    second++;
   }
  }

  return res;
 }
}
// 区间首先都按start time排序
// 为了保证两者重叠的部分增大，每次增加较早结束的区间的指针（贪心）
