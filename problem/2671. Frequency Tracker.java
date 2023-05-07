class FrequencyTracker {
    Map<Integer, Integer> freForNum;
    Map<Integer, Set<Integer>> numForFre;
    public FrequencyTracker() {
        freForNum = new HashMap<>();
        numForFre = new HashMap<>();
    }
    
    public void add(int number) {
        int oldFre = freForNum.containsKey(number) ? freForNum.get(number) : 0;
        int newFre = oldFre + 1;
        freForNum.put(number, newFre);
        if(numForFre.containsKey(oldFre)){
            numForFre.get(oldFre).remove(number);
            if(numForFre.get(oldFre).size()==0){
                numForFre.remove(oldFre);
            }
        }
        Set<Integer> set = new HashSet<>();
        if(numForFre.containsKey(newFre)){
            set = numForFre.get(newFre);
        }
        set.add(number);
        numForFre.put(newFre, set);
    }
    
    public void deleteOne(int number) {
        int oldFre = freForNum.containsKey(number) ? freForNum.get(number) : 0;
        if(oldFre==0){
            return;
        }
        numForFre.get(oldFre).remove(number);
        if(numForFre.get(oldFre).size()==0){
            numForFre.remove(oldFre);
        }
        int newFre = oldFre - 1;
        if(newFre==0){
            freForNum.remove(number);
            return;
        }
        freForNum.put(number, newFre);
        Set<Integer> set = new HashSet<>();
        if(numForFre.containsKey(newFre)){
            set = numForFre.get(newFre);
        }
        set.add(number);
        numForFre.put(newFre, set);
    }
    
    public boolean hasFrequency(int frequency) {
        if(numForFre.containsKey(frequency)){
            return true;
        }
        return false;
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */