/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 * public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == target) {
            return 0;
        }

        // find the border
        int left = 0;
        int right = 1;
        while (reader.get(right) < target) {
            left = right;
            right = right << 1;
        }

        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

}

// 为了保证log(n)的时间，以 << 1的方式寻找边界
