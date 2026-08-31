class Solution {
    private String s;
    private String t;
    private int[][] memo;

    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        memo = new int[s.length() + 1][t.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (memo[i][j] != -1) return memo[i][j];

        int skip = dfs(i + 1, j);
        int include = (s.charAt(i) == t.charAt(j)) ? dfs(i + 1, j + 1) : 0;
        return memo[i][j] = skip + include;
    }
}
