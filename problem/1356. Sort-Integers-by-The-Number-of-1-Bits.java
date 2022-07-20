class Solution {
    public int[] sortByBits(int[] arr) {
        int m = arr.length;
        Integer[] a = new Integer[m];
        for(int i=0; i<m; ++i){
            a[i] = arr[i];
        }
        Arrays.sort(a, (o1, o2)->(Integer.bitCount(o1)*10000+o1-Integer.bitCount(o2)*10000-o2));
        for(int i=0; i<m; ++i){
            arr[i] = a[i];
        }
        return arr;
    }
}

// let the bitCount contribute more to itself
