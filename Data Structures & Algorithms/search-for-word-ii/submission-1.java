class Solution {
    private int N;
    private int M;
    private boolean[][] visited;
    private Set<String> result;
    private int[][] directions;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        N = board.length;
        M = board[0].length;
        visited = new boolean[N][M];
        result = new HashSet<>();
        directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        this.board = board;

        for (String word : words) {
            root.addWord(word);
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                dfs(r, c, "", root);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int r, int c, String soFar, TrieNode curr) {
        if (!(r >= 0 && r < N) || !(c >= 0 && c < M) || visited[r][c] 
            || (curr.children[board[r][c] - 'a'] == null)) {
            return;
        }

        visited[r][c] = true;
        curr = curr.children[board[r][c] - 'a'];
        soFar += board[r][c];
        if (curr.isEnd) {
            result.add(soFar);
        }

        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], soFar, curr);
        }

        visited[r][c] = false;
    }

    private class TrieNode {
        public boolean isEnd;
        public TrieNode[] children;
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
        
        private void addWord(String word) {
            TrieNode cur = this;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = true;
        }
    }
}
