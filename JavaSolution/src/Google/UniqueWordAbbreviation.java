package Google;

/**
 * Created by xyunpeng on 2/10/16.
 */
public class UniqueWordAbbreviation {
    public class ValidWordAbbr {

        private Map<String, List<String>> dict;
        public ValidWordAbbr(String[] dictionary) {
            dict = new HashMap<>();
            for (int i = 0; i < dictionary.length; i++) {
                String t = dictionary[i];
                String ab = convert(t);
                if (!dict.containsKey(ab)) {
                    dict.put(ab, new ArrayList<>());
                }

                if (!dict.get(ab).contains(t))
                    dict.get(ab).add(t);
            }
        }

        public boolean isUnique(String word) {
            String ab = convert(word);
            if (!dict.containsKey(ab)) {
                return true;
            }

            if (dict.get(ab).contains(word) && dict.get(ab).size() == 1) {
                return true;
            }
            return false;
        }

        private String convert(String s) {
            String ab;
            if (s.length() <= 2) {
                ab = s;
            } else {
                ab = s.substring(0, 1) + Integer.toString(s.substring(1, s.length() - 1).length()) + s.substring(s.length() - 1);
            }
            return ab;
        }
    }
}


//写得很不简洁