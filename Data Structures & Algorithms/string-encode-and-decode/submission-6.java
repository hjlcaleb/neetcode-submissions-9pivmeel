class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            res.append(strs.get(i).length() + "#" + strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder lengthString = new StringBuilder();
            while (str.charAt(i) != '#') {
                lengthString.append(str.charAt(i));
                i++;
            }
            int length = Integer.parseInt(lengthString.toString());
            i++;
            StringBuilder string = new StringBuilder();
            for (int j = i; j < i + length; j++) {
                string.append(str.charAt(j));
            }
            res.add(string.toString());
            i += length;
        }
        return res;
    }
}
