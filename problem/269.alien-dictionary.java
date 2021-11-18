class Solution {
 public String alienOrder(String[] words) {
  Map<Character, List<Character>> adjList = new HashMap<>();

  // 每个节点的入度表
  Map<Character, Integer> counts = new HashMap<>();
  for (String word : words) {
   for (char c : word.toCharArray()) {
    counts.put(c, 0);
    adjList.put(c, new ArrayList<>());
   }
  }

  // 第一步首先建立邻接表和入度表
  for (int i = 0; i < words.length - 1; ++i) {
   String word1 = words[i];
   String word2 = words[i + 1];

   // 如果后面的单词是前面的prefix，不能得出order
   if (word1.length() > word2.length() && word1.startsWith(word2)) {
    return "";
   }

   // 找出word1和word2的第一个不同之处
   for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
    if (word1.charAt(j) != word2.charAt(j)) {
     adjList.get(word1.charAt(j)).add(word2.charAt(j));

     counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
     break;
    }
   }
  }

  // 第二步 BFS做拓扑排序
  StringBuilder sb = new StringBuilder();
  Queue<Character> queue = new LinkedList<>();

  for (char c : counts.keySet()) {
   if (counts.get(c).equals(0)) {
    queue.add(c);
   }
  }
  while (!queue.isEmpty()) {
   char c = queue.poll();
   sb.append(c);
   for (char next : adjList.get(c)) {

    // 入度-1
    counts.put(next, counts.get(next) - 1);

    // 入度为0的先进入队列
    if (counts.get(next).equals(0)) {
     queue.add(next);
    }
   }
  }

  // 这种情况时仅凭图中信息无法得出关系
  if (sb.length() < counts.size()) {
   return "";
  }

  return sb.toString();
 }
}
