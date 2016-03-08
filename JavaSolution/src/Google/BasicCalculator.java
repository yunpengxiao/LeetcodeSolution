package Google;

/**
 * Created by xyunpeng on 3/6/16.
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> signs = new Stack<>();
        int rs = 0;
        int sign = 1;
        signs.push(1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } else if (s.charAt(i) == '(') {
                signs.push(signs.peek() * sign);
                sign = 1;
            } else if (s.charAt(i) == ')') {
                signs.pop();
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                rs += sign * signs.peek() * Integer.parseInt(s.substring(i, j));
                i = j - 1;
            }
        }

        return rs;
    }
}
