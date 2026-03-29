class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        int total = 0;
        for (String token: tokens) {
            if (!operators.contains(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                if (token.equals("+")) {
                    total = b + a;
                } else if (token.equals("-")) {
                    total = b - a;
                } else if (token.equals("*")) {
                    total = b * a;
                } else if (token.equals("/")) {
                    total = b / a;
                }
                stack.push(total);
            }
        }
        return stack.pop();
    }
}
