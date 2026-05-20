class Solution {
    private String s;
    private List<String> wordDict;
    private Boolean[][] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        memo = new Boolean[s.length()][s.length() + 1];
        return split(0, 1);
    }

    private boolean split(int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        if (j == s.length()) {
            memo[i][j] = wordDict.contains(s.substring(i));
            return memo[i][j];
        }

        if (wordDict.contains(s.substring(i, j))) {
            memo[i][j] = split(j, j + 1);
            if (memo[i][j]) {
                return memo[i][j];
            }
        }

        memo[i][j] = split(i, j + 1);
        return memo[i][j];
    }
}
