class RandomizedSet {
    Random rand;
    List<Integer> list;
    Map<Integer, Integer> idxForNum;
    public RandomizedSet() {
        rand = new Random();
        idxForNum = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(idxForNum.containsKey(val)){
            return false;
        }
        idxForNum.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!idxForNum.containsKey(val)){
            return false;
        }
        int lastNum = list.get(list.size()-1);
        int idx = idxForNum.get(val);
        list.set(idx, lastNum);
        list.remove(list.size()-1);
        idxForNum.put(lastNum, idx);
        idxForNum.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */