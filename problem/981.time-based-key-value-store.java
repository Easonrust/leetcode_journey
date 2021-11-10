/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 */

// @lc code=start
class TimeMap {

 class ValTime {
  String val;
  int time;
 }

 Map<String, List<ValTime>> map;

 public TimeMap() {
  map = new HashMap<>();
 }

 public void set(String key, String value, int timestamp) {
  ValTime valTime = new ValTime();
  valTime.val = value;
  valTime.time = timestamp;
  List<ValTime> list = new ArrayList<>();
  if (map.containsKey(key)) {
   list = map.get(key);
  }
  list.add(valTime);

  map.put(key, list);
 }

 public String get(String key, int timestamp) {
  String res = "";
  if (!map.containsKey(key)) {
   return res;
  }
  List<ValTime> list = map.get(key);
  int i = 0;
  int j = list.size() - 1;
  while (i <= j) {
   int mid = i + (j - i) / 2;
   if (list.get(mid).time <= timestamp) {
    i = mid + 1;
   } else {
    j = mid - 1;
   }
  }
  if (j == -1) {
   return res;
  } else {
   return list.get(j).val;
  }
 }
}
// 这种二分查找的题，一定要注意边界，多思考
// 并且注意题目中给的timestamp已经是升序了，不需要再额外排序了

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
// @lc code=end
