class MyCalendar {

    TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer beforeStart = events.floorKey(start);
        Integer afterStart = events.ceilingKey(start);
        if (beforeStart != null) {
            Integer beforeEnd = events.get(beforeStart);
            if (beforeEnd > start) {
                return false;
            }
        }

        if (afterStart != null) {
            if (end > afterStart) {
                return false;
            }
        }
        events.put(start, end);
        return true;

    }
}

// 使用treeMap查看是否和前后重合

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
