class Solution {
    private String text1;
    private String text2;
    private int[][] memo;


    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[text1.length() + 1][text2.length() + 1];

        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (i >= text1.length() || j >= text2.length()) return 0;
        
        if (memo[i][j] != 0) return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dfs(i + 1, j + 1);
            return memo[i][j];
        }
        
        memo[i][j] = Math.max(dfs(i + 1, j), dfs(i, j + 1));
        return memo[i][j];

    }
}
