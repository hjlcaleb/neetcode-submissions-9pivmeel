class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int need = target.size();
        int have = 0;
        Map<Character, Integer> cur = new HashMap<>();
        int l = 0;
        String res = "";
        int minLength = Integer.MAX_VALUE;
        
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            cur.put(c, cur.getOrDefault(c, 0) + 1);
            if (target.containsKey(c) && target.get(c).equals(cur.get(c))) {
                have++;
            }

            while (have == need) {
                char rmChar = s.charAt(l);
                cur.put(rmChar, cur.get(rmChar) - 1);
                if (target.containsKey(rmChar) 
                    && cur.get(rmChar) < target.get(rmChar)) {

                    have--;
                    if (s.substring(l, r + 1).length() < minLength) {
                        res = s.substring(l, r + 1);
                        minLength = res.length();
                    }
                }
                l++;
            }
        }

        return res;
    }
}
