class Solution {
 public int[][] highFive(int[][] items) {
  List<int[]> resList = new ArrayList<>();
  Arrays.sort(items, new Comparator<>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    if (o1[0] != o2[0]) {
     return o1[0] - o2[0];
    }

    return o2[1] - o1[1];
   }
  });

  int sum = 0;
  int cnt = 0;
  for (int i = 0; i < items.length; ++i) {

   if (i == 0 || items[i][0] != items[i - 1][0]) {
    cnt = 1;
    sum = items[i][1];
   } else {
    cnt += 1;
    sum += items[i][1];
   }
   if (cnt == 5) {
    int[] temp = new int[2];
    temp[0] = items[i][0];
    temp[1] = sum / 5;
    resList.add(temp);
   }
  }

  int[][] res = new int[resList.size()][2];
  for (int i = 0; i < res.length; ++i) {
   res[i] = resList.get(i);
  }

  return res;
 }
}

// arrays sort
