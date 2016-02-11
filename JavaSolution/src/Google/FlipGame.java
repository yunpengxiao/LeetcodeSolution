package Google;

/**
 * Created by xyunpeng on 2/10/16.
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i + 1 <= s.length() - 1) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                result.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
            i++;
        }

        return result;
    }
}
