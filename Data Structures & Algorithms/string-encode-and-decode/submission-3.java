class Solution {

    public String encode(List<String> strs) {
        // length + delimiter approach
        // sample output: [LENGTH]#[actual word]
        String result = "";
        for (String word: strs) {
            result += word.length() + "#" + word;
        }
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            j++;
            result.add(str.substring(j, j + length));
            j += length;
            i = j;
        }
        return result;
    }
}
