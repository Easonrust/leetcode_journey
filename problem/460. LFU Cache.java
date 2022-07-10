class LFUCache {
    Map<Integer, Integer> keyToVal = new HashMap<>();
    Map<Integer, Integer> keyToFreq = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freqToKeys = new HashMap<>();
    
    int cap;
    int minFreq = 0;
    public LFUCache(int capacity) {
        this.cap = capacity;
    }
    
    private void makeFrequent(int key) {
        int freq = keyToFreq.get(key);
        LinkedHashSet<Integer> keys = freqToKeys.get(freq);
        
        int newFreq = freq + 1;
        keyToFreq.put(key, newFreq);
        
        keys.remove(key);
        if(keys.size()==0){
            if(minFreq==freq){
                minFreq = newFreq;
            }
            freqToKeys.remove(freq);
        }else{
            freqToKeys.put(freq, keys);
        }
        
        LinkedHashSet<Integer> newKeys = freqToKeys.getOrDefault(newFreq, new LinkedHashSet<>());
        newKeys.add(key);
        freqToKeys.put(newFreq, newKeys);
    }
    
    public int get(int key) {
        if(!keyToVal.containsKey(key)){
            return -1;
        }
        int val = keyToVal.get(key);
        makeFrequent(key);
        
        return val;
    }

    
    public void put(int key, int value) {
        if(this.cap==0){
            return;
        }
        
        if(!keyToVal.containsKey(key)){
            
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            LinkedHashSet<Integer> keys = freqToKeys.getOrDefault(1, new LinkedHashSet<>());
            keys.add(key);
            freqToKeys.put(1, keys);
            
            LinkedHashSet<Integer> minFreqKeys = freqToKeys.getOrDefault(minFreq, new LinkedHashSet<>());
            if(keyToVal.size()>cap){
                int minFreqKey = minFreqKeys.iterator().next();
                keyToVal.remove(minFreqKey);
                keyToFreq.remove(minFreqKey);
                minFreqKeys.remove(minFreqKey);
               
            }
            
            if(minFreqKeys.size()==0){
                freqToKeys.remove(minFreq);
            }
            
            minFreq = 1;
        }else{
            keyToVal.put(key, value);
            makeFrequent(key);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
