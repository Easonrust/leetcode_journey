class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int right = getRightBound(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                right++;
            } else if (right >= arr.length) {
                left--;
            } else if (x - arr[left] <= arr[right] - x) {
                left--;
            } else {
                right++;
            }
        }
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    private int getRightBound(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(arr[mid]>=x){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }
}