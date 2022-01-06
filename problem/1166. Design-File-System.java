class FileSystem {

 Map<String, Integer> map;

 public FileSystem() {
  map = new HashMap<>();
 }

 public boolean createPath(String path, int value) {
  if (path.length() < 2 || map.containsKey(path)) {
   return false;
  }

  int lastIdx = path.lastIndexOf('/');
  String parent = path.substring(0, lastIdx);
  if (map.containsKey(parent) || parent.length() == 0) {
   map.put(path, value);
   return true;
  }

  return false;
 }

 public int get(String path) {
  return map.getOrDefault(path, -1);
 }
}

// 使用hashmap即可

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */