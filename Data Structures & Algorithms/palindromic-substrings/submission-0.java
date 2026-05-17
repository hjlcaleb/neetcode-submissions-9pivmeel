class Solution {
    private String s;

    public int countSubstrings(String s) {
        this.s = s;
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

        if (s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1) == 1) {
            return 1;
        }

        return 0;
    }
}
