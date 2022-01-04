class Solution {
 public String addBoldTag(String s, String[] words) {
  boolean[] bold = new boolean[s.length()];

  // 目前为止最远的</b>
  int end = 0;

  for (int i = 0; i < s.length(); ++i) {
   for (String word : words) {
    if (s.startsWith(word, i)) {
     end = Math.max(end, i + word.length());
    }
   }

   // i在目前为止最远的</b>里面
   if (end > i) {
    bold[i] = true;
   }
  }

  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < s.length(); ++i) {
   if (!bold[i]) {
    sb.append(s.charAt(i));
    continue;
   }

   int j = i;
   while (j < s.length() && bold[j]) {
    j++;
   }
   sb.append("<b>");
   sb.append(s.substring(i, j));
   sb.append("</b>");

   i = j - 1;
  }

  return sb.toString();
 }
}

// 使用一个bold[i]的boolean array来记录每个字符是否在bold里面