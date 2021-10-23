/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
 public String largestNumber(int[] nums) {

  String[] strings = new String[nums.length];
  for (int i = 0; i < nums.length; i++) {
   strings[i] = String.valueOf(nums[i]);
  }
  Arrays.sort(strings, new Comparator<String>() {
   @Override
   public int compare(String s1, String s2) {
    return (s2 + s1).compareTo(s1 + s2);
   }
  });
  StringBuilder stringBuilder = new StringBuilder();
  for (int i = 0; i < strings.length; i++) {
   stringBuilder.append(strings[i]);
  }
  if (stringBuilder.charAt(0) == '0') {
   return "0";
  }
  return stringBuilder.toString();
 }
}

// 自己的做法根据num的每一位进行排序，不可行，比较复杂，并且new comparator 不能直接对integer排序，因为这样会有超过边界的危险,
// 因此可以将num都转化为字符串，比较组合，即s1+s2是否大于s2+s1的方法
// @lc code=end
