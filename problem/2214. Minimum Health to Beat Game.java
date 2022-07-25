class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxD = Integer.MIN_VALUE;
        long sum = 0;
        for(int d:damage){
            maxD = Math.max(maxD, d);
            sum += d;
        }
        
        long res = sum + 1 - Math.min(armor, maxD);
        
        return res;
    }
}