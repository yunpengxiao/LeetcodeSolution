package Airbnb;

/**
 * Created by xyunpeng on 3/5/16.
 */
public class WordSearchII {
    public class Solution {
        class TrieNode {
            boolean isWord;
            TrieNode[] children;

            public TrieNode() {
                this.isWord = false;
                this.children = new TrieNode[26];
            }
        }

        class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            // Inserts a word into the trie.
            public void insert(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    if (p.children[word.charAt(i) - 'a'] == null) {
                        p.children[word.charAt(i) - 'a'] = new TrieNode();
                    }
                    p = p.children[word.charAt(i) - 'a'];
                }
                p.isWord = true;
            }

            // Returns if the word is in the trie.
            public boolean search(String word) {
                TrieNode p = root;
                for (int i = 0; i < word.length(); i++) {
                    if (p.children[word.charAt(i) - 'a'] == null) {
                        return false;
                    }
                    p = p.children[word.charAt(i) - 'a'];
                }
                return p.isWord == true;

            }

            // Returns if there is any word in the trie
            // that starts with the given prefix.
            public boolean startsWith(String prefix) {
                TrieNode p = root;
                for (int i = 0; i < prefix.length(); i++) {
                    if (p.children[prefix.charAt(i) - 'a'] == null) {
                        return false;
                    }
                    p = p.children[prefix.charAt(i) - 'a'];
                }
                if (p.isWord == true) return true;
                for (int i = 0; i < 26; i++) {
                    if (p.children[i] != null) {
                        return true;
                    }
                }
                return false;
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            Set<String> result = new HashSet<>();

            if (board == null || board.length == 0 || words == null || words.length == 0) {
                return new ArrayList<>(result);
            }

            int m = board.length;
            int n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            Trie wordsTrie = new Trie();

            for (int i = 0; i < words.length; i++) {
                wordsTrie.insert(words[i]);
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    helper(board, wordsTrie, i, j, "", visited, result);
                }
            }

            return new ArrayList<>(result);
        }

        private void helper(char[][]board, Trie wordsTrie, int x, int y, String word, boolean[][] visited, Set<String> result) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] == true) {
                return ;
            }

            word += board[x][y];
            if (!wordsTrie.startsWith(word)) {
                return ;
            }

            if (wordsTrie.search(word)) {
                result.add(word);
            }

            visited[x][y] = true;
            helper(board, wordsTrie, x + 1, y, word, visited, result);
            helper(board, wordsTrie, x, y + 1, word, visited, result);
            helper(board, wordsTrie, x - 1, y, word, visited, result);
            helper(board, wordsTrie, x, y - 1, word, visited, result);
            visited[x][y] = false;
        }
    }
}


//感觉没有任何难度,就是要实现那个trie,然后就是个普通的DFS了