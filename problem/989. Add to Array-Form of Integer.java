class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String kStr = String.valueOf(k);
        int carry = 0;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while(i<Math.min(num.length, kStr.length())){
            int ki = kStr.length() - i - 1;
            int numi = num.length - i - 1;
            int res = (kStr.charAt(ki)-'0') + num[numi] + carry;
            carry = res/10;
            int cur = res%10;
            list.add(cur);
            i++;
        }
        while(i<num.length){
            int numi = num.length - i - 1;
            int res = num[numi] + carry;
            carry = res/10;
            int cur = res%10;
            list.add(cur);
            i++;
        }
        while(i<kStr.length()){
            int ki = kStr.length() - i - 1;
            int res = (kStr.charAt(ki)-'0') + carry;
            carry = res/10;
            int cur = res%10;
            list.add(cur);
            i++;
        }
        if(carry!=0){
            list.add(carry);
        }
        Collections.reverse(list);
        return list;
    }
}