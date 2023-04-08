class Solution {
    public int maximumSwap(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int n = numArr.length;
        int idx1 = -1;
        int idx2 = -2;
        int maxIdx = n-1;
        for(int i=n-1; i>=0; i--){
            if(numArr[i]>numArr[maxIdx]){
                maxIdx = i;
            }
            if(numArr[i]<numArr[maxIdx]){
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if(idx1!=-1&&idx2!=-1){
            swap(numArr, idx1, idx2);
        }
        return Integer.parseInt(new String(numArr));
    }

    private void swap(char[] numArr, int i, int j) {
        char temp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = temp;
    }
}