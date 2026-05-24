class Solution {
    int n;
    List<String> result;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        result = new ArrayList<>();
        backtrack("", 0, 0);
        return result;

    }

    private void backtrack(String cur, int numOpen, int numClose) {
        if (cur.length() >= 2 * n) {
            if (numOpen == n && numClose == n) {
                result.add(cur);
            }
            return;
        }

        if (numClose > numOpen) {
            return;
        }

        backtrack(cur + "(", numOpen + 1, numClose);
        backtrack(cur + ")", numOpen, numClose + 1);
    }
}
