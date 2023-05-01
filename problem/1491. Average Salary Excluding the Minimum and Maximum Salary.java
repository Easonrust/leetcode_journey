class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int salar:salary){
            sum += salar;
            minVal = Math.min(minVal, salar);
            maxVal = Math.max(maxVal, salar);
        }

        return (double)(sum-minVal-maxVal)/(double)(salary.length-2);
    }
}