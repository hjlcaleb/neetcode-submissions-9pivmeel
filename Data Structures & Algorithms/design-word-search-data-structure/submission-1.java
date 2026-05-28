class WordDictionary {

    private class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    private boolean dfs(TrieNode root, int start, String word) {
        TrieNode cur = root;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : cur.children) {
                    if (child != null && dfs(child, i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isEnd;
    }
}
