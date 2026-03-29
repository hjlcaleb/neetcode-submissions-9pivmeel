class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {  
            while (l < r && !isAlphaNumeric(s.toLowerCase().charAt(l))) {
                l++;
            }
            while (r > l && !isAlphaNumeric(s.toLowerCase().charAt(r))) {
                r--;
            }
            if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
