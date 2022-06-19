class ProductOfNumbers {

    List<Integer> preProduct = new ArrayList<>();

    public ProductOfNumbers() {
        preProduct.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            preProduct.clear();
            preProduct.add(1);
        } else {
            int n = preProduct.size();
            preProduct.add(preProduct.get(n - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = preProduct.size();
        if (k > n - 1) {
            return 0;
        }
        return preProduct.get(n - 1) / preProduct.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
