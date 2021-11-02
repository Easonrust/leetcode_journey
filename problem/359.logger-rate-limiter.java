class Logger {
 Map<String, Integer> map;

 public Logger() {
  map = new HashMap<>();
 }

 public boolean shouldPrintMessage(int timestamp, String message) {
  if (map.containsKey(message)) {
   if (map.get(message) <= timestamp) {
    map.put(message, timestamp + 10);
    return true;
   }
   return false;
  } else {
   map.put(message, timestamp + 10);
   return true;
  }
 }
}