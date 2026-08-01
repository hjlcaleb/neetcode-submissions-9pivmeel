class Solution {
    public int compress(char[] chars) {
        int k = 0;
        int end = 0;
        while (end < chars.length) {
            int length = 1;
            char currentChar = chars[end];
            while (end + 1 < chars.length && chars[end] == chars[end + 1]) {
                end++;
                length++;
            }
            chars[k++] = currentChar;
            if (length > 1) {
                String grouping = String.valueOf(length);
                for (char c : grouping.toCharArray()) {
                    chars[k++] = c;
                }
            }
            end++;
        }
        return k;
    }
}