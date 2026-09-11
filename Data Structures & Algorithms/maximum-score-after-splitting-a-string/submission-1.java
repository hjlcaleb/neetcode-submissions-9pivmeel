class Solution {
    public int maxScore(String s) {
        int res = 0;
        int numZeros = 0;
        int numOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                numOnes++;
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                numZeros++;
            } else {
                numOnes--;
            }
            res = Math.max(numZeros + numOnes, res);
        }
        return res;
    }
}