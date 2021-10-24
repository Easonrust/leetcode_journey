/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
 public int[] plusOne(int[] digits) {
     int n=digits.length;
     int carry=1;
     for(int i=n-1;i>=0;--i){
         int temp=digits[i]+carry;
         digits[i]=temp%10;
         carry=temp/10;
     }
     if(carry!=0){
         int[] res=new int[digits.length+1];
         res[0]=carry;
         for(int i=1;i<res.length;++i){
             res[i]=digits[i-1];
         }
         return res;
     }else{
         return digits;
     }
     
 }
}
// easy
// @lc code=end

