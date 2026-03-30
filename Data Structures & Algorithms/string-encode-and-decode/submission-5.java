class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length() + "#" + str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            String length = "";
            while (str.charAt(i) != '#') {
                length += str.charAt(i);
                i++;
            }
            i++; // skip delimiter
            int intLength = Integer.parseInt(length);
            result.add(str.substring(i, i + intLength));
            i += intLength;
        }
        return result;
    }
}
