/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
 public List<List<String>> groupAnagrams(String[] strs) {
  Map<String, List> map = new HashMap<>();
  for (String str : strs) {
   char[] c = str.toCharArray();
   Arrays.sort(c);
   String tmp = Arrays.toString(c);
   if (map.containsKey(tmp)) {
    List<String> list = map.get(tmp);
    list.add(str);
    map.put(tmp, list);
   } else {
    List<String> list = new ArrayList<>();
    list.add(str);
    map.put(tmp, list);
   }
  }
  List<List<String>> res = new ArrayList<>();
  for (List<String> list : map.values()) {
   res.add(list);
  }
  return res;

 }
 // 判断两个字符串是否是同构的只需将原字符串进行排序即可，不一定要计算每个字符出现的个数，像这种分类问题大部分都是使用hashmap求解的
}
// @lc code=end
