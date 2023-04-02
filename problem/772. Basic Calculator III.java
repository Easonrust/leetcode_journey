class Solution {
    public int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for(char c:s.toCharArray()){
            q.offer(c);
        }
        return helper(q);
    }

    public int helper(Queue<Character> q) {
        int num = 0;
        char sign = '+';
        Deque<Integer> stack = new LinkedList<>();
        while(!q.isEmpty()){
            char c = q.poll();
            if(Character.isDigit(c)){
                num = 10*num + (c-'0');
            }

            if(c=='('){
                num = helper(q);
            }

            if(!Character.isDigit(c)||q.isEmpty()){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    int pre = stack.pop();
                    stack.push(pre*num);
                }else if (sign == '/'){
                    int pre = stack.pop();
                    stack.push(pre/num);
                }
                sign = c;
                num = 0;
            }

            if(c==')'){
                break;
            }
        }

        int res = 0;
        for(int re:stack){
            res += re;
        }
        return res;
    }
}