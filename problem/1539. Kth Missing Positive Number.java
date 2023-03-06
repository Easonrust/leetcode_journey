class Solution {
    public int findKthPositive(int[] arr, int k) {
        int res = 1;
        int i = 0;
        while(true){
            if(i<arr.length&&arr[i]==res){
                i++;
            }else{
                k--;
            }
            if(k==0){
                break;
            }
            res++;
        }
        return res;
    }
}