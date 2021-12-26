/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=start
class Solution {
 public void nextPermutation(int[] nums) {
     int i=nums.length-2;
     
     while(i>=0&&nums[i+1]<=nums[i]){
         i--;
     }
     
     if(i>=0){
         int j=nums.length-1;
         while(nums[j]<=nums[i]){
             j--;
         }
         swap(nums,i,j);
     }
     
     
     reverse(nums,i+1);
 }
 
 
 private void reverse(int[] nums, int start){
     int i=start, j=nums.length-1;
     
     while(i<j){
         swap(nums,i,j);
         i++;
         j--;
     }
 }
 
 private void swap(int[] nums, int i, int j){
     int temp=nums[i];
     nums[i]=nums[j];
     nums[j]=temp;
 }
}

// 找到从右数第一个不符合递减的元素i, 因为i右侧的序列为递减序列，所以右侧内部怎么交换字典序都不会变大，因此将i与右侧序列中最小的比i大的元素交换后，再把右侧变为递增，能找到下一字典序
// 如果没找到i，说明整个序列都相当于右侧递减序列，直接变为递增
// @lc code=end

