class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < parts.length; ++i) {
            String part = parts[i];
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(part);
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        if (res.isEmpty()) {
            return "/";
        }

        return res;
    }
}
