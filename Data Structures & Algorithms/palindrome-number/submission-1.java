class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String integer = String.valueOf(x);
        int l = 0;
        int r = integer.length() - 1;
        while (l < r) {
            if (integer.charAt(l) != integer.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}