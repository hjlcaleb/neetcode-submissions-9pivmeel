class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> difToGroup = new HashMap<>();
        for (String s : strings) {
            StringBuilder hashKey = new StringBuilder();
            for (int j = 0; j < s.length() - 1; j++) {
                hashKey.append((char) 
                    ((s.charAt(j) - s.charAt(j + 1) + 26) % 26) + '0');
                if (j != s.length() - 2) {
                    hashKey.append(',');
                }
            }
            difToGroup.computeIfAbsent(hashKey.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<List<String>>(difToGroup.values());
    }
}
