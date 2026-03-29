class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetPerm = new int[26];
        int[] currPerm = new int[26];

        for (char c : s1.toCharArray()) {
            targetPerm[c - 'a'] += 1;
        }

        for (int i = 0; i < s1.length() - 1; i++) {
            currPerm[s2.charAt(i) - 'a'] += 1;
        }

        int l = 0;
        int r = s1.length() - 1;
        while (r < s2.length()) {
            currPerm[s2.charAt(r) - 'a'] += 1;
            if (samePerm(currPerm, targetPerm)) {
                return true;
            }
            currPerm[s2.charAt(l) - 'a'] -= 1;
            l++;
            r++;
        }
        return false;
    }

    private boolean samePerm(int[] l1, int[] l2) {
        for (int i = 0; i < l1.length; i++) {
            if (l1[i] != l2[i]) return false;
        }
        return true;
    }
}
