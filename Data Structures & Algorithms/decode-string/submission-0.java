class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.substring(i, i + 1));
            } else {
                String substring = "";
                while (!stack.peek().equals("[")) {
                    substring = stack.pop() + substring;
                }
                stack.pop();
                String k = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k = stack.pop() + k;
                }
                int count = Integer.parseInt(k);
                stack.push(substring.repeat(count));
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}