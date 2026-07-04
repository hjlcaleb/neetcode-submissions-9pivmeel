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
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String word = q.remove();
                visited.add(word);
                if (word.equals(endWord)) return numWords;
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neighbor : adj.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neighbor)) {
                            q.add(neighbor);
                        }
                    }
                }
            }
            numWords++;
        }
        
        return 0;
    }

    private boolean oneDiff(String w1, String w2) {
        int numDiff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w2.charAt(i) != w1.charAt(i)) numDiff++;
        }

        return numDiff == 1;
    }
}
