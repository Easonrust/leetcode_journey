class Solution {
    public String reverseWords(String s) {
        String ts = s.trim();
        String rs = reverseWord(ts);
        String[] arr = rs.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(reverseWord(arr[0]));
        
        for(int i=1; i<arr.length; ++i){
            sb.append(" ");
            sb.append(reverseWord(arr[i]));
        }
        
        return sb.toString();
    }
    
    private String reverseWord(String w) {
        StringBuilder sb = new StringBuilder(w);
        
        int l = 0;
        int r = sb.length()-1;
        while(l<r){
            char c1 = sb.charAt(l);
            char c2 = sb.charAt(r);
            
            sb.setCharAt(l, c2);
            sb.setCharAt(r, c1);
            
            l++;
            r--;
        }
        
        return sb.toString();
    }
}
