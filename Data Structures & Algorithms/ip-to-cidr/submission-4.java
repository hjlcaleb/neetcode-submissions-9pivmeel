class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        long cur = toLong(ip);
        while (n > 0) {
            int numTrailingZeros = (int) Long.numberOfTrailingZeros(cur);
            int bitVal = 1;
            int count = 0;           
            
            while (bitVal < n && count < numTrailingZeros) {
                bitVal <<= 1;
                count++;
            }

            if (bitVal > n) {
                bitVal >>= 1;
                count--;
            }

            result.add(toString(cur, 32 - count));
            cur += bitVal;
            n -= bitVal;
        }
        return result;
    }

    private String toString(long cur, int range) {
        StringBuilder block = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            block.append(Long.toString(cur >> (i * 8) & 255));
            if (i != 0) {
                block.append('.');
            } else {
                block.append('/');
            }
        }
        block.append(range);
        return block.toString();
    }

    private long toLong(String ip) {
        String[] octets = ip.split("\\.");
        long result = 0;
        for (int i = 0; i <= 3; i++) {
            result *= 256;
            result += Long.parseLong(octets[i]);
        }
        return result;
    }
}
