class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 != 0) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[r];
    }
}
// @lc code=end
// 单元素一定在偶数位上,因题目的复杂度要求，使用二分查找法进行求解
// 只要出现h=m就要写l<h
