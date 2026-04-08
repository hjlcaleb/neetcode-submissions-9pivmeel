class MyCircularQueue {
    private int front;
    private int back;
    private int[] queue;
    private int size;

    public MyCircularQueue(int k) {
        front = 0;
        back = -1;
        queue = new int[k];
        size = 0;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            back = (back + 1) % queue.length;
            queue[back] = value;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % queue.length;
            size--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (!isEmpty()) {
            return queue[front];
        }
        return -1;
    }
    
    public int Rear() {
        if (!isEmpty()) {
            return queue[back];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */