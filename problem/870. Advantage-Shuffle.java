class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));

        for (int i = 0; i < nums2.length; ++i) {
            pq.offer(new int[] { i, nums2[i] });
        }

        Arrays.sort(nums1);
        int left = 0;
        int right = nums1.length - 1;

        int[] res = new int[nums2.length];
        while (!pq.isEmpty()) {
            int[] num2Arr = pq.poll();
            int idx = num2Arr[0];
            int num2 = num2Arr[1];
            if (num2 < nums1[right]) {
                res[idx] = nums1[right];
                right--;
            } else {
                res[idx] = nums1[left];
                left++;
            }
        }
        return res;
    }
}

// 田忌赛马
