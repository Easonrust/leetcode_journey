import java.util.ArrayList;

import java.util.*;

public class App {
 public static List<Integer> getUnallottedUsers(int totalShares, int[][] bids) {
  List<Integer> res = new ArrayList<>();
  if (bids.length == 1) {
   if (bids[0][1] > totalShares) {
    res.add(bids[0][0]);
   }
   return res;
  }

  Arrays.sort(bids, new Comparator<int[]>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    if (o1[2] != o2[2]) {
     return o2[2] - o1[2];
    } else {
     return o1[3] - o2[3];
    }
   }
  });
  Map<Integer, Integer> map = new HashMap<>();
  for (int i = 0; i < bids.length; ++i) {
   map.put(bids[i][2], map.getOrDefault(bids[i][2], 0) + 1);
  }
  int i = 0;
  int count = 0;
  int[] origin = new int[bids.length];
  for (int l = 0; l < origin.length; ++l) {
   origin[l] = bids[l][1];
  }
  while (totalShares > 0 && i < bids.length) {
   if (map.get(bids[i][2]) == 1) {
    if (totalShares > bids[i][1]) {
     totalShares -= bids[i][1];
     bids[i][1] -= bids[i][1];

    } else {
     totalShares -= bids[i][1];
     bids[i][1] -= totalShares;

     break;
    }
    i++;
   } else {
    count = map.get(bids[i][2]);
    int cnt = count;
    for (int j = i; j < i + cnt; ++j) {
     if (bids[j][1] != 0) {
      bids[j][1] -= 1;
      totalShares -= 1;

     }
     if (bids[j][1] == 0) {
      count -= 1;
     }
     if (totalShares == 0) {
      break;
     }
    }
    if (count == 0) {
     i += count;
    }
   }
  }
  for (int m = 0; m < origin.length; ++m) {
   if (origin[m] == bids[m][1]) {
    res.add(bids[m][0]);
   }
  }
  Collections.sort(res);
  return res;

 }

 public static void main(String args[]) {
  int[][] bids = new int[][] { { 1, 3, 1, 9866 }, { 2, 1, 2, 5258 }, { 3, 2, 4, 5788 }, { 4, 2, 4, 6536 } };

  List<Integer> res = getUnallottedUsers(2, bids);
  Collections.sor
  System.out.println("hello");
 }
}