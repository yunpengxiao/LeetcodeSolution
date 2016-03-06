package Google;

/**
 * Created by xyunpeng on 3/5/16.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> result = new HashMap<>();

        if (strings == null || strings.length == 0) {
            return new ArrayList<List<String>>();
        }

        for (String s : strings) {
            StringBuilder t = new StringBuilder("a");
            int gap = s.charAt(0) - 'a';
            for (int i = 1; i < s.length(); i++) {
                t.append(shift(s.charAt(i), gap));
            }
            String key = t.toString();
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }

            result.get(key).add(s);
        }

        List<List<String>> ret = new ArrayList<>();
        for (String key : result.keySet()) {
            java.util.Collections.sort(result.get(key));
            ret.add(result.get(key));
        }

        return ret;
    }

    private char shift(char c, int gap) {
        char result = (char) (c - gap);
        if (result > 'z') {
            result = (char)(result - 'z' + 'a' - 1);
        } else if (result < 'a') {
            result = (char)('z' + result - 'a' + 1);
        }

        return result;
    }
}

//自己想出来的,但是代码不是很简洁