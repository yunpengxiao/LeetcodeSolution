package Google;

/**
 * Created by xyunpeng on 4/24/16.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> hashmap = new HashMap<>();
        Map<String, Character> hashmap1 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (hashmap.containsKey(pattern.charAt(i)) && !hashmap.get(pattern.charAt(i)).equals(words[i])) {
                return false;
            }

            if (hashmap1.containsKey(words[i]) && hashmap1.get(words[i]) != pattern.charAt(i)) {
                return false;
            }

            if (!hashmap.containsKey(pattern.charAt(i))) {
                hashmap.put(pattern.charAt(i), words[i]);
            }

            if (!hashmap1.containsKey(words[i])) {
                hashmap1.put(words[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
