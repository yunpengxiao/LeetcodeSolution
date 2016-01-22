package FaceBook;

/**
 * Created by xyunpeng on 1/20/16.
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

public class AddandSearchWord {
    // Adds a word into the data structure.
    public class WordDictionary {
        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                if (p.children[word.charAt(i) - 'a'] == null) {
                    p.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                p = p.children[word.charAt(i) - 'a'];
            }
            p.isWord = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return helper(word, root);
        }

        private boolean helper(String word, TrieNode root) {
            if (root == null) return false;
            if (word.length() == 0 && root.isWord == true) {
                return true;
            }
            if (word.length() == 0 && root.isWord == false) {
                return false;
            }
            if (word.charAt(0) != '.') {
                return helper(word.substring(1), root.children[word.charAt(0) - 'a']);
            } else {
                for (int i = 0; i < 26; i++) {
                    if (helper(word.substring(1), root.children[i])) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}

//居然又一次过...