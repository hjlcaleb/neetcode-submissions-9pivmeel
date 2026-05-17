class Solution {
    private String s;
    private int[][] memo;

    public int countSubstrings(String s) {
        this.s = s;
        this.memo = new int[s.length()][s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                count += isPalindrome(i, j);
            }
        }
        return count;
    }

    private int isPalindrome(int i, int j) {
        if (i == j) {
            return 1;
        }

        if (j == i + 1) {
            return (s.charAt(i) == s.charAt(j)) ? 1 : 0;
        }

        if (memo[i][j] != 0) return memo[i][j];

        memo[i][j] = (s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1) == 1) ? 1 : 0;

        return memo[i][j];
    }
}
