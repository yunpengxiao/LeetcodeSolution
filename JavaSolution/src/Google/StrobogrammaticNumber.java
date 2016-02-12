package Google;

/**
 * Created by xyunpeng on 2/11/16.
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }

        Map<Character, Character> hashmap = new HashMap<>();
        hashmap.put('0', '0');
        hashmap.put('1', '1');
        hashmap.put('6', '9');
        hashmap.put('8', '8');
        hashmap.put('9', '6');
        StringBuilder t = new StringBuilder("");
        for (int i = num.length() - 1; i >= 0; i--) {
            if (!hashmap.containsKey(num.charAt(i))) {
                return false;
            }

            t.append(hashmap.get(num.charAt(i)));
        }

        return t.toString().equals(num);
    }
}
