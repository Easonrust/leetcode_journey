class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long l = 0;
        long r = (long)totalTrips*(long)time[0];
        while(l<r){
            long mid = l + (r-l)/2;
            if(check(time,mid,totalTrips)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }

    boolean check(int[] time, long mid, int totalTrips) {
        long trips = 0;
        for(int tim:time){
            trips += (int)(mid/tim);
        }
        return trips>=totalTrips;
    }
}