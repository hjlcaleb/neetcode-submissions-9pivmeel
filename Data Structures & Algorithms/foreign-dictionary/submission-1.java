class Solution {
    private Map<Character, Set<Character>> adjList;
    private StringBuilder result;
    private Map<Character, Boolean> visited;

    public String foreignDictionary(String[] words) {
        adjList = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjList.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int minLength = Math.min(word1.length(), word2.length());
            if (word1.length() > word2.length() &&
                word1.substring(0, minLength).equals(word2.substring(0, minLength))) {
                
                return "";
            }
            for (int j = 0; j < minLength; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new StringBuilder();
        for (char c : adjList.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        return result.reverse().toString();
    }

    private boolean dfs(char c) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);
        for (char neighbor : adjList.get(c)) {
            if (dfs(neighbor)) {
                return true;
            }
        }
        visited.put(c, false);
        result.append(c);
        return false;
    }
}
