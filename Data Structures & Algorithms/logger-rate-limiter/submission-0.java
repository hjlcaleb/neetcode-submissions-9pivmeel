class Logger {
    private Map<String, Integer> curMessage;
    public Logger() {
        curMessage = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!curMessage.containsKey(message)) {
            curMessage.put(message, timestamp);
            return true;
        }

        if (curMessage.get(message) + 10 > timestamp) return false;
        curMessage.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
