class MyStack {
    private Queue<Integer> main;

    public MyStack() {
        main = new LinkedList<>();
    }
    
    public void push(int x) {
        main.add(x);
    }
    
    public int pop() {
        int qSize = main.size();
        for (int i = 0; i < qSize - 1; i++) {
            main.add(main.remove());
        }
        return main.remove();
    }
    
    public int top() {
        int addBack = this.pop();
        main.add(addBack);
        return addBack;
    }
    
    public boolean empty() {
        return main.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */