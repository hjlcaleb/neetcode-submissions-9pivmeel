class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() -1;

        while(l < r){
            while(l < r && !alphaNumeric(s.charAt(l))){
                l++;
            }

            while(r > l && !alphaNumeric(s.charAt(r))){
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            
            l++;
            r--;
        }

        return true;

    }

    private boolean alphaNumeric(char c){
        return (c >= 'a' && c <= 'z')
        || (c >= 'A' && c <= 'Z')
        || (c >= '0' && c <= '9');
    }
}
