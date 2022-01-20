class Solution {
 public boolean canPermutePalindrome(String s) {
  int[] chs = new int[26];
  for (char c : s.toCharArray()) {
   chs[c - 'a']++;
  }

  int cnt = 0;
  for (int c : chs) {
   if (c % 2 != 0) {
    cnt++;
   }
   if (cnt > 1) {
    return false;
   }
  }

  return true;
 }
}
