class StockSpanner {
    Stack<Integer> stream;

    public StockSpanner() {
        stream = new Stack<>();
    }
    
    public int next(int price) {
        Stack<Integer> aux = new Stack<>();
        stream.push(price);
        int span = 0;
        while (!stream.isEmpty() && stream.peek() <= price) {
            aux.push(stream.pop());
            span++;
        }
        
        while (!aux.isEmpty()) {
            stream.push(aux.pop());
        }
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */