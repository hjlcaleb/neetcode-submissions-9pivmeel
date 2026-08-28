class Solution {
    String s;
    int[][] memo;

    public boolean isValidPalindrome(String s, int k) {
        this.s = s;
        memo = new int[s.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, s.length() - 1) <= k;
    }

    private int dfs(int l, int r) { 
        if (memo[l][r] != -1) return memo[l][r];

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return memo[l][r] = 1 + Math.min(dfs(l + 1, r), dfs(l, r - 1));
            }
            l++;
            r--;
        }
        return 0;
    }
}
