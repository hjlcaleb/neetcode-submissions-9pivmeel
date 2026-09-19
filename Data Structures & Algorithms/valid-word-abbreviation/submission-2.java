class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (abbr.charAt(j) == '0') {
                return false;
            }

            String length = "";
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) { 
                length += abbr.charAt(j);
                j++;
            }
            if (length != "") {
                i += Integer.parseInt(length);
            }
            if (j >= abbr.length() && i == word.length()) {
                return true;
            }

            if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return i == word.length() && j == abbr.length();
    }
}