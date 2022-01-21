class Solution {
 public boolean isOneEditDistance(String s, String t) {
  int m = s.length();
  int n = t.length();

  if (m > n) {
   return isOneEditDistance(t, s);
  }

  for (int i = 0; i < m; ++i) {
   if (s.charAt(i) != t.charAt(i)) {
    if (m == n) {
     return s.substring(i + 1).equals(t.substring(i + 1));
    } else {
     return s.substring(i).equals(t.substring(i + 1));
    }
   }
  }

  // 此时前m个都相同，只有t比s恰好多一个的时候才符合条件
  return n == m + 1;
 }
}
