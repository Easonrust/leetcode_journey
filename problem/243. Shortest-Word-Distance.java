class Solution {
 public int shortestDistance(String[] wordsDict, String word1, String word2) {
  Deque<Integer> stack = new LinkedList<>();
  int res = Integer.MAX_VALUE;
  for (int i = 0; i < wordsDict.length; ++i) {
   String word = wordsDict[i];
   if (word.equals(word1) || word.equals(word2)) {
    if (stack.isEmpty()) {
     stack.push(i);
     continue;
    }

    if (!wordsDict[stack.peek()].equals(word)) {
     res = Math.min(res, i - stack.peek());
    }
    stack.push(i);
   }
  }
  return res;
 }
}

// 使用stack
