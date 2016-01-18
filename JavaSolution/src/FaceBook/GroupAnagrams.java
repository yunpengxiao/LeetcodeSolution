package FaceBook;

import java.util.*;

/**
 * Created by xyunpeng on 1/17/16.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> wordmap = new HashMap<>();
        for (String s : strs) {
            String t = getHashKey(s);
            if (wordmap.containsKey(t)) {
                wordmap.get(t).add(s);
            } else {
                List<String> newWordList = new ArrayList<>();
                newWordList.add(s);
                wordmap.put(t, newWordList);
            }
        }

        for (String s : wordmap.keySet()) {
            Collections.sort(wordmap.get(s));
            res.add(wordmap.get(s));
        }

        return res;
    }

    private String getHashKey(String s) {
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
