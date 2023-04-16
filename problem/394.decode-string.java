class Solution {
    public String decodeString(String s) {
        String str = "";
        Deque<String> strStack = new LinkedList<>();
        Deque<Integer> numStack = new LinkedList<>();
        int idx = 0;
        while(idx<s.length()){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                int num = 0;
                while(idx<s.length()&&Character.isDigit(s.charAt(idx))){
                    num = num*10 + (s.charAt(idx)-'0');
                    idx++;
                }
                numStack.push(num);
            }else if(ch=='['){
                strStack.push(str);
                str = "";
                idx++;
            }else if(ch==']'){
                int num = numStack.pop();
                StringBuilder sb = new StringBuilder(strStack.pop());
                for(int i=0; i<num; ++i){
                    sb.append(str);
                }
                str = sb.toString();
                idx++;
            }else{
                str += ch;
                idx++;
            }
        }
        return str;
    }
}