/*
 * @lc app=leetcode id=692 lang=java
 *
 * [692] Top K Frequent Words
 */

// @lc code=start
class Solution {
 public List<String> topKFrequent(String[] words, int k) {
  Map<String, Integer> map = new HashMap<>();
  List<String> temp = new ArrayList<>();
  for (String word : words) {
   if (!map.containsKey(word)) {
    temp.add(word);
   }
   map.put(word, map.getOrDefault(word, 0) + 1);
  }

  Collections.sort(temp, new Comparator<>() {
   @Override
   public int compare(String o1, String o2) {
    int f1 = map.get(o1);
    int f2 = map.get(o2);
    if (f1 != f2) {
     return f2 - f1;
    }
    return o1.compareTo(o2);
   }
  });

  String[] res = new String[k];
  for (int i = 0; i < k; ++i) {
   res[i] = temp.get(i);
  }

  return new ArrayList<>(Arrays.asList(res));
 }
}
// 记得要对数组元素进行去重
// @lc code=end
