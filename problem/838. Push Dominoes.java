class Solution {
    public String pushDominoes(String dominoes) {
        String temp = "L" + dominoes + "R";
        char[] chs = temp.toCharArray();
        StringBuilder sb = new StringBuilder();
        int l = 0;
        for(int r=1; r<chs.length; ++r){
            if(chs[r]=='.'){
                continue;
            }
            if(l!=0){
                sb.append(chs[l]);
            }
            int cnt = r-l-1;
            if(chs[l]==chs[r]){
                for(int i=1; i<=cnt; ++i){
                    sb.append(chs[l]);
                }
            }else if(chs[l]=='L'&&chs[r]=='R'){
                for(int i=1; i<=cnt; ++i){
                    sb.append(chs[l+i]);
                }
            }else{
                for(int i=1; i<=cnt/2; ++i){
                    sb.append('R');
                }
                if(cnt%2!=0){
                    sb.append('.');
                }
                for(int i=1; i<=cnt/2; ++i){
                    sb.append('L');
                }
            }
            l = r;
        }
        return sb.toString();
    }
}