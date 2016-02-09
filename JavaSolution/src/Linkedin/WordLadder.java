package Linkedin;

/**
 * Created by xyunpeng on 2/8/16.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }

        int level = 1;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        queue.offer(null);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            if (word == null) {
                level++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                for (int i = 0; i < word.length(); i++) {
                    char[] wordLetters = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordLetters[i] = c;
                        String ts = String.valueOf(wordLetters);
                        if (ts.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordList.contains(ts) && !visited.contains(ts)) {
                            queue.offer(ts);
                            visited.add(ts);
                        }
                    }
                }
            }
        }

        return 0;
    }
}

