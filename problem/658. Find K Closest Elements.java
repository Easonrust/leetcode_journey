class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = findRightBound(arr, x);
        int left = right-1;
        for(int i=0; i<k; ++i){
            if(left<0){
                right++;
            }else if(right>=arr.length){
                left--;
            }else if(x-arr[left]<=arr[right]-x){
                left--;
            }else{
                right++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=left+1; i<=right-1; ++i){
            res.add(arr[i]);
        }
        return res;
    }
    
    private int findRightBound(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(arr[mid]>=x){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
