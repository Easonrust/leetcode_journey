/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
 public int findCelebrity(int n) {
  int candidate = 0;
  for (int i = 1; i < n; ++i) {
   if (knows(candidate, i)) {
    candidate = i;
   }
  }
  if (isCelebrity(candidate, n)) {
   return candidate;
  }
  return -1;
 }

 private boolean isCelebrity(int candidate, int n) {
  for (int i = 0; i < n; ++i) {
   if (i == candidate) {
    continue;
   }
   if (knows(candidate, i) || !knows(i, candidate)) {
    return false;
   }
  }
  return true;
 }
}

// knows(candidate, i) true,
// 说明candidate不是celebrity，i可能是；false，说明candidate依然可能是celebrity，i不可能是