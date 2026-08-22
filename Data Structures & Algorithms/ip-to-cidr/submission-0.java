class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        List<String> result = new ArrayList<>();
        int cur = toInt(ip);
        while (n > 0) {
            int maxBits = Integer.numberOfTrailingZeros(cur);
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

            result.add(toString(cur, 32 - count));
            n -= bitVal;
            cur += bitVal;
        }
        return result;
    }

    private String toString(int number, int range) {
        int WORD_SIZE = 8;
        StringBuilder sb = new StringBuilder();

        for (int i = 3; i >= 0; i--) {
            sb.append(Integer.toString(((number >> (i * WORD_SIZE)) & 255)));
            if (i != 0) {
                sb.append(".");
            }
        }

        sb.append("/");
        sb.append(Integer.toString(range));
        return sb.toString();
    }
    
    private int toInt(String ip) {
        String[] sep = ip.split("\\.");
        int sum = 0;
        for (int i = 0; i < sep.length; i++) {
            sum *= 256;
            sum += Integer.parseInt(sep[i]);
        }
        return sum;
    }
}
