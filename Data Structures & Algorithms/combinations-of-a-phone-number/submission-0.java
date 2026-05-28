class Solution {
    String[] digitToChar;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        digitToChar = new String[]{"", "", "abc", "def", "ghi", "jkl", 
            "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        backtrack(digits, result, 0, "");
        return result;
    }

    private void backtrack(String digits, List<String> result, int curDigit, String cur) {
        if (cur.length() == digits.length()) {
            result.add(cur);
            return;
        }

        int digit = digits.charAt(curDigit) - '0';
        for (int i = 0; i < digitToChar[digit].length(); i++) {
            char c = digitToChar[digit].charAt(i);
            backtrack(digits, result, curDigit + 1, cur + c);
        }
    }
}
