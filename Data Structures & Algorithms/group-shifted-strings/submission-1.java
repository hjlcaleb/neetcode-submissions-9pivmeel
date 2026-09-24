class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> difToGroup = new HashMap<>();
        for (String s : strings) {
            StringBuilder hashKey = new StringBuilder();
            for (int j = 1; j < s.length(); j++) {
                hashKey.append((char) 
                    ((s.charAt(j) - s.charAt(j - 1) + 26) % 26) + '0');
                if (j != s.length() - 1) {
                    hashKey.append(',');
                }
            }
            difToGroup.computeIfAbsent(hashKey.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<List<String>>(difToGroup.values());
    }
}
