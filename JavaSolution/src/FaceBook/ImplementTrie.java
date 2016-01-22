package FaceBook;

/**
 * Created by xyunpeng on 1/21/16.
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;                           //也有这里用hashmap实现的

    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}

public class ImplementTrie {
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
}

//居然一次过
//参考资料: http://songlee24.github.io/2015/05/09/prefix-tree/