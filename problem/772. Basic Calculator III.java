class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(char ch:s.toCharArray()){
            queue.offer(ch);
        }
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        int sign = '+';
        while(!queue.isEmpty()){
            char ch = queue.poll();
            if(Character.isDigit(ch)){
                num = num * 10 + (ch-'0');
            }

            if(ch=='('){
                num = helper(queue);
            }

            if(!Character.isDigit(ch)||queue.isEmpty()){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = ch;
                num = 0;
            }

            if(ch==')'){
                break;
            }
        }

        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}