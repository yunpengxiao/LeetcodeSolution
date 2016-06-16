package FaceBook;

/**
 * Created by xyunpeng on 5/31/16.
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = map.get(s.charAt(s.length() - 1));
        int pivot = result;
        for (int i = s.length() - 2; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur >= pivot) {
                result += cur;
            } else {
                result -= cur;
            }
            pivot = cur;
        }

        return result;
    }
}


//对罗马数字的规则不是怎么了解: https://leetcode.com/discuss/42582/my-java-solution