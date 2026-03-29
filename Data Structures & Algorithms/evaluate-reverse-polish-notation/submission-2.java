class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>();

        int result = 0;

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String c : tokens){
            if(operators.contains(c)){
                
                if(c.equals("+")){
                    stack.push(stack.pop() + stack.pop());
                } else if (c.equals("*")){
                    stack.push(stack.pop() * stack.pop());
                } else if (c.equals("/")){
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 / val2);
                } else if (c.equals("-")){
                    int val2 = stack.pop();
                    int val1 = stack.pop();
                    stack.push(val1 - val2);
                }
                                
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}
