/*
 * @lc app=leetcode id=1041 lang=java
 *
 * [1041] Robot Bounded In Circle
 */

// @lc code=start
class Solution {
 public boolean isRobotBounded(String instructions) {
  int[] p = new int[2];
  String direction = "n";
  for (char c : instructions.toCharArray()) {
   if (c == 'G') {
    if (direction == "n") {
     p[1]++;
    } else if (direction == "s") {
     p[1]--;
    } else if (direction == "e") {
     p[0]++;
    } else {
     p[0]--;
    }
   } else if (c == 'L') {
    if (direction == "n") {
     direction = "w";
    } else if (direction == "s") {
     direction = "e";
    } else if (direction == "e") {
     direction = "n";
    } else if (direction == "w") {
     direction = "s";
    }
   } else if (c == 'R') {
    if (direction == "n") {
     direction = "e";
    } else if (direction == "s") {
     direction = "w";
    } else if (direction == "e") {
     direction = "s";
    } else if (direction == "w") {
     direction = "n";
    }
   }
  }
  if ((p[0] == 0 && p[1] == 0) || direction != "n") {
   return true;
  }
  return false;
 }
}
// @lc code=end
// 当且仅当执行一系列指令后机器人在原位置或方向有改变时，是在一个园上
