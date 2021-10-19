/*
 * @lc app=leetcode id=48 lang=java
 *
 * [48] Rotate Image
 */

// @lc code=start
class Solution {
 public void rotate(int[][] matrix) {
     
     //transpose
     for(int i=0;i<matrix.length;++i){
         for(int j=i;j<matrix[0].length;++j){
             int tmp=matrix[i][j];
             matrix[i][j]=matrix[j][i];
             matrix[j][i]=tmp;
         }
     }   
     
     //reverse
     for(int i=0;i<matrix.length;++i){
         int first=0;
         int end=matrix[i].length-1;
         while(first<end){
             int tmp=matrix[i][first];
             matrix[i][first]=matrix[i][end];
             matrix[i][end]=tmp;
             first++;
             end--;
         }
     }
 }
// @lc code=end
