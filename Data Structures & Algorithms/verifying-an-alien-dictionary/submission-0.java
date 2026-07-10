class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int ordering = 0;
        int[] chars = new int[26];
        for (int i = 0; i < chars.length; i++) {
            chars[(int) (order.charAt(i) - 'a')] = ordering++;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String firstWord = words[i];
            String secondWord = words[i + 1];
            if (firstWord.startsWith(secondWord) && firstWord.length() > secondWord.length()) {
                return false;
            }

            for (int j = 0; j < Math.min(firstWord.length(), secondWord.length()); j++) {
                if (firstWord.charAt(j) != secondWord.charAt(j)) {
                    if (chars[firstWord.charAt(j) - 'a'] > chars[secondWord.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}