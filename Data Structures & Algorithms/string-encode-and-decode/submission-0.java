class Solution {

    public String encode(List<String> strs) {
        String encoding = "";

        for(int i = 0; i < strs.size(); i++){
            String temp = strs.get(i);
            encoding += temp.length() + "#" + temp;
        }
        return encoding;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        while(!str.isEmpty()){
            int count = Integer.parseInt(str.substring(0, str.indexOf("#")));
            result.add(str.substring(str.indexOf("#") + 1, str.indexOf("#") + 1 + count));
            int chunkLength = str.substring(0, str.indexOf("#")).length() + 1 + count;
            str = str.substring(str.indexOf("#") + 1 + count);
        }

        return result;
    }
}
