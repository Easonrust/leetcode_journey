class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] p : points) {
            Set<Integer> set = new HashSet<>();
            if (map.containsKey(p[0])) {
                set = map.get(p[0]);
            }

            set.add(p[1]);
            map.put(p[0], set);
        }

        int res = Integer.MAX_VALUE;
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    res = Math.min(res, Math.abs((p2[0] - p1[0]) * (p2[1] - p1[1])));
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

// 取对角线元素，map存同一横坐标的所有纵坐标值
