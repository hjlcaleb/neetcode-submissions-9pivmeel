class StockSpanner {
    Stack<int[]> stream;

    public StockSpanner() {
        stream = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stream.isEmpty() && stream.peek()[0] <= price) {
            span += stream.pop()[1];
        }
        
        stream.push(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */