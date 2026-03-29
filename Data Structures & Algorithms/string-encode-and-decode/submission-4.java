class Solution {

    public String encode(List<String> strs) {
        String encoding = "";
        for (String s : strs) {
            encoding += s.length() + "#" + s;
        }
        return encoding;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            result.add(str.substring(j, j + length));
            i = j + length;
        }
        return result;
    }
}
