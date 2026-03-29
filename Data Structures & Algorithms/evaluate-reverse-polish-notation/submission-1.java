class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();

        int result = 0;

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        for(String c : tokens){
            if(operators.contains(c)){
                int val2 = Integer.parseInt(stack.pop());
                int val1 = Integer.parseInt(stack.pop());
                
                if(c.equals("+")){
                    result = (val1 + val2);
                } else if (c.equals("*")){
                    result = (val1 * val2);
                } else if (c.equals("/")){
                    result = (val1/val2);
                } else if (c.equals("-")){
                    result = (val1 - val2);
                }
                
                stack.push(result + "");
                

            } else {
                stack.push(c);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
