import java.util.ArrayList;

import java.util.*;

public class App {
 public static String longestPalindrome(String s) {
  String res = findLongestPalindrome(s);
  return res;
 }

 static String findLongestPalindrome(String s) {
  if (isPalindrome(s)) {
   return s;
  }

  String str1 = findLongestPalindrome(s.substring(1));
  String str2 = findLongestPalindrome(s.substring(0, s.length() - 1));
  if (str1.length() > str2.length()) {
   return str1;
  }
  return str2;
 }

 static boolean isPalindrome(String s) {
  int n = s.length();
  int i = 0;
  int j = n - 1;
  while (i < j) {
   if (s.charAt(i++) != s.charAt(j--)) {
    return false;
   }
  }
  return true;
 }

 public static void main(String args[]) {
  

  System.out.println(longestPalindrome("baba"));
 }
}