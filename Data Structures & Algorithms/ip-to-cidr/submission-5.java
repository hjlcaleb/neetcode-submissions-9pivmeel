class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long cur = toLong(ip);
        List<String> res = new ArrayList<>();
        while (n > 0) {
            long limit = Long.numberOfTrailingZeros(cur);
            int bitVal = 1;
            int count = 0;

            while (bitVal < n && count < limit) {
                bitVal <<= 1;
                count++;
            }

            if (bitVal > n) {
                bitVal >>= 1;
                count--;
            }

            res.add(toString(cur, 32 - count));
            cur += bitVal;
            n -= bitVal;
        }
        
        return res;
    }

    private long toLong(String ip) {
        long sum = 0;
        String[] components = ip.split("\\.");
        for (String comp : components) {
            sum *= 256;
            sum += Long.parseLong(comp);
        }
        return sum;
    }

    private String toString(long cur, int range) {
        StringBuilder block = new StringBuilder();
        int WORD_SIZE = 8;
        for (int i = 3; i >= 0; i--) {
            block.append(Long.toString((cur >> (WORD_SIZE * i) & 255)));
            if (i != 0) {
                block.append('.');
            }
        }
        block.append('/');
        block.append(range);
        return block.toString();
    }
}
