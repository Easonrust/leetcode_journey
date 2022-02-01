class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backTracking(result, item, n, 2);
        return result;
    }

    private void backTracking(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n == 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        // 这里i可以等于1是因为上面限制了item大小大于1时才加入result
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                backTracking(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}

// backtracking
