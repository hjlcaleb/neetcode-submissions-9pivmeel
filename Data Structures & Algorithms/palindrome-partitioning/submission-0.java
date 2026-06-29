class Solution {
    private List<List<String>> result;
    private List<String> cur;
    private String s;
    
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        cur = new ArrayList<>();
        this.s = s;
        backtrack(0);
        return result;
    }

    private void backtrack(int start) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                cur.add(s.substring(start, end + 1));
                backtrack(end + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String sub) {
        int l = 0;
        int r = sub.length() - 1;
        while (l <= r) {
            if (sub.charAt(l) != sub.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
