class Solution {
 public int lengthOfLongestSubstringKDistinct(String s, int k) {
  int n = s.length();
  int right = 0;
  int left = 1;
  int res = 0;

  if (n == 0) {
   return res;
  }

  Map<Character, Integer> map = new HashMap<>();
  map.put(s.charAt(0), 1);
  int curLength = 1;

  while (left <= n) {
   if (checkString(map, k)) {
    res = Math.max(res, curLength);
    left++;
    if (left <= n) {
     char c1 = s.charAt(left - 1);
     map.put(c1, map.getOrDefault(c1, 0) + 1);
    }
    curLength++;
   } else {
    right++;
    char c2 = s.charAt(right - 1);
    map.put(c2, map.getOrDefault(c2, 0) - 1);
    curLength--;
   }
  }
  return res;
 }

 private boolean checkString(Map<Character, Integer> map, int k) {
  boolean res = true;
  int cnt = 0;
  for (char c : map.keySet()) {
   if (map.get(c) >= 1) {
    cnt++;
   }
  }

  if (cnt > k) {
   res = false;
  }

  return res;
 }
}

// sliding window
