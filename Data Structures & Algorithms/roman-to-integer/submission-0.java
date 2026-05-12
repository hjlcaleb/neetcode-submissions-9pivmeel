class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> r2i = new HashMap<>();
        r2i.put("I", 1);
        r2i.put("V", 5);
        r2i.put("X", 10);
        r2i.put("L", 50);
        r2i.put("C", 100);
        r2i.put("D", 500);
        r2i.put("M", 1000);

        r2i.put("IV", 4);
        r2i.put("IX", 9);
        r2i.put("XL", 40);
        r2i.put("XC", 90);
        r2i.put("CD", 400);
        r2i.put("CM", 900);

        int total = 0;
        int i = 0;
        while (i < s.length()) {
            if (i + 1 < s.length() && r2i.containsKey(s.substring(i, i + 2))) {
                total += r2i.get(s.substring(i, i + 2));
                i += 2;
            } else if (r2i.containsKey(s.substring(i, i + 1))) {
                total += r2i.get(s.substring(i, i + 1));
                i++;
            }
        }
        return total;
    }
}