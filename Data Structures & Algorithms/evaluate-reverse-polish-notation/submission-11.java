class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");
        for (String token : tokens) {
            if (!operators.contains(token)) {
                operands.push(Integer.parseInt(token));
            } else {
                int a = operands.pop();
                int b = operands.pop();
                if (token.equals("+")) {
                    operands.push(b + a);
                } else if (token.equals("-")) {
                    operands.push(b - a);
                } else if (token.equals("*")) {
                    operands.push(b * a);
                } else {
                    operands.push(b / a);
                }
            }
        }
        return operands.peek();
    }
}
