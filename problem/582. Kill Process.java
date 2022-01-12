class Solution {
 Map<Integer, List<Integer>> map;
 List<Integer> res;

 public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
  map = new HashMap<>();
  res = new ArrayList<>();

  for (int i = 0; i < pid.size(); ++i) {
   List<Integer> temp = new ArrayList<>();
   if (map.containsKey(ppid.get(i))) {
    temp = map.get(ppid.get(i));
   }

   temp.add(pid.get(i));
   map.put(ppid.get(i), temp);
  }

  res.add(kill);
  dfs(kill);

  return res;
 }

 private void dfs(int kill) {
  if (!map.containsKey(kill)) {
   return;
  }

  List<Integer> childs = map.get(kill);

  for (int child : childs) {
   res.add(child);
   dfs(child);
  }

  return;
 }

}

// DFS
