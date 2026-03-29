class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int currMin;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        currMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.push(val);
        currMin = Math.min(currMin, val);
        minStack.push(currMin);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        if (minStack.isEmpty()) {
            currMin = Integer.MAX_VALUE;
        } else {
            currMin = minStack.peek();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
