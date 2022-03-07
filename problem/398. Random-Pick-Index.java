class Solution {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    public Solution(int[] nums) {
        rand = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> temp = new ArrayList<>();
            if (map.containsKey(nums[i])) {
                temp = map.get(nums[i]);
            }
            temp.add(i);
            map.put(nums[i], temp);
        }
    }

    public int pick(int target) {
        List<Integer> temp = map.get(target);
        int size = temp.size();
        return temp.get(rand.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
