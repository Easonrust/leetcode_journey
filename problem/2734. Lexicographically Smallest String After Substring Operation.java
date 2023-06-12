class Solution {
    public String smallestString(String s) {
        char[] chs = s.toCharArray();
        int start = 0;
        while(start<chs.length&&chs[start]=='a'){
            start++;
        }
        int end = start+1;
        while(end<chs.length&&chs[end]!='a'){
            end++;
        }
        if(start==chs.length){
            chs[start-1] = 'z';
        }else{
            for(int i=start; i<end; ++i){
                chs[i] -= 1;
            }
        }

        return new String(chs);
        
    }
}