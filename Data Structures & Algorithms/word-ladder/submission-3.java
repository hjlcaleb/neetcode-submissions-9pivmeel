class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> adj = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                adj.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        
        int numWords = 1;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String word = q.remove();
                if (word.equals(endWord)) return numWords;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neighbor : adj.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            q.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
            numWords++;
        }
        
        return 0;
    }
}
