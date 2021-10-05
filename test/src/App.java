import java.util.ArrayList;

import java.util.*;

public class App {
 public static int getMinJump(int flagHeight, int bigJump) {
  int[] dp = new int[flagHeight + 1];
  dp[0] = 0;
  dp[1] = 1;
  for (int i = 2; i <= flagHeight; ++i) {
   if (i < bigJump) {
    dp[i] = dp[i - 1] + 1;
   } else {
    dp[i] = Math.min(dp[i - 1] + 1, dp[i - bigJump] + 1);
   }

  }
  return dp[flagHeight];
 }

 public static void main(String args[]) {
  int[][] bids = new int[][] { { 1, 3, 1, 9866 }, { 2, 1, 2, 5258 }, { 3, 2, 4, 5788 }, { 4, 2, 4, 6536 } };

  int result=getMinJump(8, 3);

  System.out.println(result);
 }
}