class Solution {

 char shiftLetter(char letter, char first) {
  return (char) ((letter - first + 26) % 26 + 'a');
 }

 String getHash(String string) {
  StringBuilder sb = new StringBuilder();
  char first = string.charAt(0);
  for (char c : string.toCharArray()) {
   sb.append(shiftLetter(c, first));
  }
  return sb.toString();
 }

 public List<List<String>> groupStrings(String[] strings) {
  Map<String, List<String>> map = new HashMap<>();

  for (String string : strings) {
   String key = getHash(string);
   List<String> list = new ArrayList<>();
   if (map.containsKey(key)) {
    list = map.get(key);
   }
   list.add(string);
   map.put(key, list);
  }

  List<List<String>> res = new ArrayList<>();
  for (String key : map.keySet()) {
   res.add(map.get(key));
  }
  return res;
 }
}

// C++/Java: a % b = a - int(a / b) * b
// Python: a % b = a - floor(a / b) * b

// In C++/Java expression like (a - b) % c can be negative if a < b hence we
// need to manually add c to make it non-negative (a - b + c) % c