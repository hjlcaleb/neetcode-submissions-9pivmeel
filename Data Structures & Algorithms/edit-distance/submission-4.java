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
        return edit(0, 0);
    }

    private int edit(int i, int j) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = edit(i + 1, j + 1);
        }

        return memo[i][j] = 1 + Math.min(edit(i, j + 1), Math.min(edit(i + 1, j), edit(i + 1, j + 1)));
    }
}
