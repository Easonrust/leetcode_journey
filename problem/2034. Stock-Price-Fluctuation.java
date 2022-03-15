class StockPrice {
    TreeMap<Integer, Integer> stocks;
    TreeMap<Integer, Integer> priceCnt;

    public StockPrice() {
        stocks = new TreeMap<>();
        priceCnt = new TreeMap<>();

    }

    public void update(int timestamp, int price) {
        if (stocks.containsKey(timestamp)) {
            int curPrice = stocks.get(timestamp);
            if (priceCnt.get(curPrice) > 1) {
                priceCnt.put(curPrice, priceCnt.get(curPrice) - 1);
            } else {
                priceCnt.remove(curPrice);
            }
        }
        stocks.put(timestamp, price);
        priceCnt.put(price, priceCnt.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return stocks.get(stocks.lastKey());
    }

    public int maximum() {
        return priceCnt.lastKey();
    }

    public int minimum() {
        return priceCnt.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

// TreeMap
