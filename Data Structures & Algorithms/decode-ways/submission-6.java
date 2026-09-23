class Solution {
    private String s;
    private int[] memo;

    public int numDecodings(String s) {
        this.s = s;
        this.memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return numWays(s, 0);
    }

    private int numWays(String cur, int i) {
        if (i == cur.length()) return 1;
        if (cur.charAt(i) == '0' || i > cur.length()) return 0;

        if (memo[i] != -1) return memo[i];
        
        int total = 0;
        total += numWays(cur, i + 1);
        if (i + 1 < cur.length()) {
            int curVal = Integer.parseInt(cur.substring(i, i + 2));
            if (10 <= curVal && curVal <= 26) {
                total += numWays(cur, i + 2);
            }
        }

        return memo[i] = total;
    }
}
