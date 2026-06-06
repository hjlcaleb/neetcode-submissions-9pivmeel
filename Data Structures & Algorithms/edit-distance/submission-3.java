class Solution {
    private String word1;
    private String word2;
    private int[][] memo;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        this.memo = new int[word1.length() + 1][word2.length() + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return edit(word1.length(), word2.length());
    }

    private int edit(int i, int j) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return memo[i][j] = edit(i - 1, j - 1);
        }

        return memo[i][j] = 1 + Math.min(edit(i, j - 1), Math.min(edit(i - 1, j), edit(i - 1, j - 1)));
    }
}
