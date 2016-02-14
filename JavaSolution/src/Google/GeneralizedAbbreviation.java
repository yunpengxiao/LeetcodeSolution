package Google;

/**
 * Created by xyunpeng on 2/13/16.
 */
public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        helper(word, 0, 0, "", result);
        return result;
    }

    private void helper(String word, int start, int count, String cur, List<String> result) {
        if (start == word.length()) {
            if (count > 0) cur += count;
            result.add(cur);
        } else {
            helper(word, start + 1, count + 1, cur, result);
            helper(word, start + 1, 0, cur + (count == 0? "": count) + word.charAt(start), result);
        }
    }
}


//真尼玛想得出来:  https://leetcode.com/discuss/75754/java-backtracking-solution