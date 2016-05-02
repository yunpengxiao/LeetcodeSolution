package Uber;

/**
 * Created by xyunpeng on 4/30/16.
 */
public class WordPatternII {
    Map<Character, String> patternMap = new HashMap<>();
    Set<String> showed = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty() && str.isEmpty()) {
            return true;
        }

        if (pattern.isEmpty() || str.isEmpty()) {
            return false;
        }

        char c = pattern.charAt(0);
        String subPattern = pattern.substring(1);
        if (patternMap.containsKey(c)) {
            String cs = patternMap.get(c);
            if (str.startsWith(cs)) {
                return wordPatternMatch(subPattern, str.substring(cs.length()));
            } else {
                return false;
            }
        }


        for (int i = 1; i <= str.length(); i++) {
            String substr = str.substring(0, i);
            if (showed.contains(substr)) {
                continue;
            }
            patternMap.put(c, substr);
            showed.add(substr);
            if (wordPatternMatch(subPattern, str.substring(i))) {
                return true;
            }
            showed.remove(substr);
            patternMap.remove(c);
        }

        return false;
    }
}


//我的思路和https://leetcode.com/discuss/63252/share-my-java-backtracking-solution 是一样的.只不过我没有多定义一个函数罢了