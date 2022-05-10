class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.getLast() <= nums2[i]) {
                stack.removeLast();
            }
            for (int j = 0; j < res.length; ++j) {
                if (nums1[j] == nums2[i]) {
                    res[j] = stack.isEmpty() ? -1 : stack.getLast();
                    break;
                }
            }
            stack.addLast(nums2[i]);
        }
        return res;
    }
}

// Monotonic stack
