class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        long div = 1;
        while (x >= 10 * div) {
            div *= 10;
        }

        while (x > 0) {
            long l = x / div;
            long r = x % 10;
            if (l != r) return false;
            x = (int)(x % div) / 10;
            div /= 100;
        }
        return true;
    }
}