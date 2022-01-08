class LogSystem {

 Map<Integer, String> map;

 public LogSystem() {
  map = new HashMap<>();
 }

 public void put(int id, String timestamp) {
  map.put(id, timestamp);
 }

 public List<Integer> retrieve(String start, String end, String granularity) {
  int precise = 19;
  List<Integer> res = new ArrayList<>();

  if (granularity.equals("Year")) {
   precise = 4;
  } else if (granularity.equals("Month")) {
   precise = 7;
  } else if (granularity.equals("Day")) {
   precise = 10;
  } else if (granularity.equals("Hour")) {
   precise = 13;
  } else if (granularity.equals("Minute")) {
   precise = 16;
  } else {
   precise = 19;
  }

  start = start.substring(0, precise);
  end = end.substring(0, precise);

  String temp;
  for (int key : map.keySet()) {
   temp = map.get(key).substring(0, precise);
   if (temp.compareTo(start) >= 0 && temp.compareTo(end) <= 0) {
    res.add(key);
   }
  }
  return res;
 }
}
// 字符串比较一定要用equals和compareTo
/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(start,end,granularity);
 */