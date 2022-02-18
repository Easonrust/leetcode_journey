class UndergroundSystem {
    private Map<String, Pair<Integer, Integer>> tripMap;
    private Map<Integer, Pair<String, Integer>> userMap;

    public UndergroundSystem() {
        tripMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        userMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> user = userMap.get(id);
        String startStation = user.getKey();
        int startTime = user.getValue();
        String tripKey = getTripKey(startStation, stationName);
        int totalTime = t - startTime;
        Pair<Integer, Integer> trip = tripMap.getOrDefault(tripKey, new Pair<>(0, 0));
        Pair<Integer, Integer> newTrip = new Pair<>(trip.getKey() + totalTime, trip.getValue() + 1);
        tripMap.put(tripKey, newTrip);
    }

    public double getAverageTime(String startStation, String endStation) {
        Pair<Integer, Integer> trip = tripMap.get(getTripKey(startStation, endStation));
        int totalTime = trip.getKey();
        int totalUser = trip.getValue();
        return (double) totalTime / (double) totalUser;
    }

    private String getTripKey(String startStation, String endStation) {
        return startStation + "->" + endStation;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
