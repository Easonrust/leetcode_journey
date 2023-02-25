class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        String x = str1.substring(0,gcd(l1, l2));
        if(check(str1, x)&&check(str2, x)){
            return x;
        }
        return "";
    }

    private boolean check(String str, String x) {
        StringBuilder sb = new StringBuilder();
        int m = str.length()/x.length();
        for(int i=0; i<m; ++i){
            sb.append(x);
        }
        return str.equals(sb.toString());
    }

    private int gcd(int a, int b) {
        int remainder = a%b;
        while(remainder!=0){
            a = b;
            b = remainder;
            remainder = a%b;
        }
        return b;
    }
}