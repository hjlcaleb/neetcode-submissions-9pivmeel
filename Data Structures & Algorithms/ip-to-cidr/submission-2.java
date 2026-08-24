class Solution {
    final int WORD_SIZE = 8;

    public List<String> ipToCIDR(String ip, int n) {
        long cur = toLong(ip);
        List<String> res = new ArrayList<>();
        while (n > 0) {
            int maxBits = (int) Long.numberOfTrailingZeros(cur);
            int bitVal = 1;
            int count = 0;
            while (bitVal < n && count < maxBits) {
                bitVal <<= 1;
                count++;
            }

            if (bitVal > n) {
                bitVal >>= 1;
                count--;
            }

            res.add(toString(cur, 32 - count));
            n -= bitVal;
            cur += bitVal;
        }
        return res;
    }

    private String toString(long number, int range) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            sb.append(Long.toString((number >> (i * WORD_SIZE)) & 255));
            if (i != 0) {
                sb.append(".");
            }
        }
        sb.append("/");
        sb.append(Integer.toString(range));
        return sb.toString();
    }
    
    private long toLong(String ip) {
        long sum = 0;
        String[] parts = ip.split("\\.");
        for (int i = 0; i < parts.length; i++) {
            sum *= 256;
            sum += Long.parseLong(parts[i]);
        }
        return sum;
    }
}
