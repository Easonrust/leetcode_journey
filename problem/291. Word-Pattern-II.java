class Solution {

 public boolean wordPatternMatch(String pattern, String s) {
  Map<Character, String> map = new HashMap<>();
  Set<String> set = new HashSet<>();

  return isMatch(s, 0, pattern, 0, map, set);

 }

 boolean isMatch(String s, int i, String pattern, int j, Map<Character, String> map, Set<String> set) {
  // base case
  if (i == s.length() && j == pattern.length()) {
   return true;
  }

  // recursion检查的过程中可能有任意一方用完，说明不能match
  if (i == s.length() || j == pattern.length()) {
   return false;
  }

  char c = pattern.charAt(j);

  // map 中已经存在c的映射的情况
  if (map.containsKey(c)) {
   String temp = map.get(c);

   // 检查是否从i开始存在该字符串
   if (!s.startsWith(temp, i)) {
    return false;
   }

   // 如果能够match，继续向下检查
   return isMatch(s, i + temp.length(), pattern, j + 1, map, set);
  }

  // map 中还不存在c的映射的情况
  for (int k = i; k < s.length(); ++k) {
   String p = s.substring(i, k + 1);

   // 检查p是否已经被映射过了
   if (set.contains(p)) {
    continue;
   }

   map.put(c, p);
   set.add(p);

   // 以此开始继续向下映射检查
   if (isMatch(s, k + 1, pattern, j + 1, map, set)) {
    return true;
   }

   // 上面检查没过的话，回溯, 继续循环看映射别的可不可以
   map.remove(c);
   set.remove(p);
  }

  // c 一个也映射不了
  return false;
 }
}

// backTracking
