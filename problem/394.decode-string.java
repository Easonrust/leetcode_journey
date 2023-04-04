class Solution {
    public String decodeString(String s) {
        String str = "";
        int idx = 0;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();
        while(idx<s.length()){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                int num = 0;
                while(Character.isDigit(s.charAt(idx))){
                    num = num*10 + (s.charAt(idx)-'0');
                    idx++;
                }
                numStack.push(num);
            }else if(ch=='['){
                strStack.push(str);
                str = "";
                idx++;
            }else if(ch==']'){
                StringBuilder sb = new StringBuilder(strStack.pop());
                int n = numStack.pop();
                for(int i=0; i<n; ++i){
                    sb.append(str);
                }
                str = sb.toString();
                idx++;
            }else{
                str+=ch;
                idx++;
            }
        }
        return str;
    }
}