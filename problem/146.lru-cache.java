class LRUCache {
    
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            int val = cache.get(key);
            cache.remove(key);
            cache.put(key,val);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        
        cache.put(key, value);
        if(cache.size()>this.cap){
            cache.remove(cache.keySet().iterator().next());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */