class Solution {
    private int[] array;
    private int[] original;
    private Random rand;

    public Solution(int[] nums) {
        array = nums.clone();
        original = nums.clone();
        rand = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; ++i) {
            swap(i, rand.nextInt(i, array.length));
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

// Fisher-Yates 算法，注意对于基本类型的数组，clone是深拷贝，swap(i,rand.nextInt(i,array.length))，
// 前面交换过的后面就不再考虑

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
