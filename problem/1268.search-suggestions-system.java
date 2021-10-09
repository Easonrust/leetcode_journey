/*
 * @lc app=leetcode id=1268 lang=java
 *
 * [1268] Search Suggestions System
 */

// @lc code=start
class Solution {
 public List<List<String>> suggestedProducts(String[] products, String searchWord) {
  Arrays.sort(products);
  List<List<String>> res = new ArrayList<>();
  int n = searchWord.length();
  for (int i = 1; i <= n; ++i) {
   String prefix = searchWord.substring(0, i);
   List<String> product = new ArrayList<>();
   int cnt = 0;
   for (int j = 0; j < products.length; ++j) {
    if (isPrefix(prefix, products[j])) {
     cnt++;
     product.add(products[j]);
    }
    if (cnt == 3) {
     break;
    }
   }
   res.add(product);
  }
  return res;
 }

 boolean isPrefix(String prefix, String s) {
  int m = prefix.length();
  int n = s.length();
  if (m > n) {
   return false;
  }
  for (int i = 0; i < m; ++i) {
   if (prefix.charAt(i) != s.charAt(i)) {
    return false;
   }
  }
  return true;
 }
}
// @lc code=end
