class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> adj = new HashMap<>();
        if (!wordList.contains(beginWord)) wordList.add(beginWord);

        for (String word : wordList) {
            adj.put(word, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < wordList.size(); j++) {
                if (j != i && oneDiff(wordList.get(j), wordList.get(i))) {
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
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
                for (String neighbor : adj.get(word)) {
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor);
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
