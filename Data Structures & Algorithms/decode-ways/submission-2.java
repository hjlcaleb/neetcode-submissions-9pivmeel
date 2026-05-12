class Solution {
    private String s;
    private int INFTY = 1000000;
    private int[] memo;

    public int numDecodings(String s) {
        this.s = s;
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(0);

    }

    private int dfs(int i) {
        if (i == s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = dfs(i + 1);
        if (i + 1 < s.length()) {
            int digitPair = Integer.parseInt(s.substring(i, i + 2));
            if (digitPair <= 26) {
                memo[i] += dfs(i + 2);
            }
        }
        
        return memo[i];
    }
}
