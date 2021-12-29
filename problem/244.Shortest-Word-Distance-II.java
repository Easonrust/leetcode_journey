class WordDistance {
 Map<String, List<Integer>> map;

 public WordDistance(String[] wordsDict) {
  map = new HashMap<>();
  for (int i = 0; i < wordsDict.length; ++i) {
   List<Integer> list = new ArrayList<>();
   if (map.containsKey(wordsDict[i])) {
    list = map.get(wordsDict[i]);
   }
   list.add(i);
   map.put(wordsDict[i], list);
  }
 }

 public int shortest(String word1, String word2) {
  List<Integer> list1 = map.get(word1);
  List<Integer> list2 = map.get(word2);
  int minD = Integer.MAX_VALUE;
  for (int p1 : list1) {
   for (int p2 : list2) {
    minD = Math.min(minD, Math.abs(p1 - p2));
   }
  }
  return minD;
 }
}

// hashmap