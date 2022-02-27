/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
// class Solution {
//  public void rotate(int[] nums, int k) {

//   if (nums == null) {
//    return;
//   }
//   int n = nums.length;
//   k = k % n;
//   if (n < 2 || k == 0) {
//    return;
//   }

//   rotate(nums, 0, n - 1);
//   rotate(nums, 0, k - 1);
//   rotate(nums, k, n - 1);

//  }

//  private void rotate(int[] nums, int i, int j) {
//   while (i < j) {
//    int tmp = nums[i];
//    nums[i] = nums[j];
//    nums[j] = tmp;
//    j--;
//    i++;
//   }
//  }
// }
// // @lc code=end
// // 若 k=3，nums=[1,2,3,4,5,6,7]。

// // 先将 nums 整体翻转：[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]

// // 再翻转 0~k-1 范围内的元素：[7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]

// // 最后翻转 k~n-1 范围内的元素，即可得到最终结果：[5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]

class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
