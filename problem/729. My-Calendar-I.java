class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();        
    }
    
    public boolean book(int start, int end) {
        Integer beforeStart = calendar.floorKey(start);
        Integer afterStart = calendar.ceilingKey(start);
        if(beforeStart!=null){
            int beforeEnd = calendar.get(beforeStart);
            if(beforeEnd>start){
                return false;
            }
        }
        
        if(afterStart!=null){
            if(end>afterStart){
                return false;
            }
        }
        
        calendar.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */