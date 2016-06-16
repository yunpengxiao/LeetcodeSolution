package Google;

/**
 * Created by xyunpeng on 6/5/16.
 */
public class WordSearchII {
    class TrieNode {
        char letter;
        boolean isWord;
        TrieNode[] children;

        // Initialize your data structure here.
        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public TrieNode(char c) {
            this.letter = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                int index = word.charAt(i) - 'a';
                if (p.children[index] == null) {
                    p.children[index] = new TrieNode(word.charAt(i));
                }
                p = p.children[index];
            }
            p.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode p = root;
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                int index = word.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }

            return p.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            int prefixLen = prefix.length();
            for (int i = 0; i < prefixLen; i++) {
                int index = prefix.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
            }
            return true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();

        int m = board.length;
        int n = board[0].length;
        int len = words.length;
        if (m == 0 || n == 0 || len == 0) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (int i = 0; i < len; i++) {
            trie.insert(words[i]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, i, j, trie, "", result);
            }
        }

        return new ArrayList<>(result);
    }

    private void helper(char[][] board, int x, int y, Trie trie, String word, Set<String> result) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
                !Character.isLetter(board[x][y]) || !trie.startsWith(word)) {
            return ;
        }

        char c = board[x][y];
        word += c;
        if (trie.search(word)) {
            result.add(word);
        }
        board[x][y] = '#';
        helper(board, x + 1, y, trie, word, result);
        helper(board, x - 1, y, trie, word, result);
        helper(board, x, y + 1, trie, word, result);
        helper(board, x, y - 1, trie, word, result);
        board[x][y] = c;
    }
}
