class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patternToWord = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternToWord.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int numWords = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                String curWord = q.remove();
                if (curWord.equals(endWord)) return numWords;
                for (int j = 0; j < curWord.length(); j++) {
                    String pattern = curWord.substring(0, j) + "*" + curWord.substring(j + 1);
                    if (patternToWord.containsKey(pattern)) {
                        for (String nextWord : patternToWord.get(pattern)) {
                            if (!visited.contains(nextWord)) {
                                visited.add(nextWord);
                                q.add(nextWord);
                            }
                        }
                    }
                }
                visited.add(curWord);
            }
            numWords++;
        }
        return 0;
    }
}
