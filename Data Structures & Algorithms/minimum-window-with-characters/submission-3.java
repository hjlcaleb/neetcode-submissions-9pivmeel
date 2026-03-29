class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }        

        Map<Character, Integer> needFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            needFreq.put(c, needFreq.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = needFreq.size();

        Map<Character, Integer> currFreq = new HashMap<>();

        int l = 0;
        int r = l;

        String result = "";
        int resultLength = Integer.MAX_VALUE;

        while (r < s.length()) {
            char c = s.charAt(r);
            if (needFreq.keySet().contains(c)) {
                currFreq.put(c, currFreq.getOrDefault(c, 0) + 1);
                if (currFreq.get(c) == needFreq.get(c)) {
                    have++;
                }
                while (have == need) {
                    // update result
                    if (resultLength > (r - l + 1)) {
                        result = s.substring(l, r + 1);
                        resultLength = r - l + 1;
                    }
                    // pop from the left
                    if (needFreq.keySet().contains(s.charAt(l))) {
                        currFreq.put(s.charAt(l), currFreq.get(s.charAt(l)) - 1);
                        if (currFreq.get(s.charAt(l)) < needFreq.get(s.charAt(l))) {
                            have--;
                        }
                    }
                    l++;
                }
            } 
            r++;
        }
        return result;
    }
}
