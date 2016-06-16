package Uber;

/**
 * Created by xyunpeng on 3/1/16.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();
        int m = str.length();
        long result = 0;
        int sign = 1;
        for (int i = 0; i < m; i++) {
            char t = str.charAt(i);
            if (i == 0 && t == '-') {
                sign = -1;
            } else if (i == 0 && t == '+') {
                continue;
            } else if (t >= '0' && t <= '9') {
                result = result * 10 + (t - 48);
                if (result * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (result * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                return helper(result * sign);
            }
        }

        return helper(result * sign);
    }

    private int helper(long sum) {
        if (sum > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (sum < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) sum;
    }

    //这个解法更好懂也更好和面试官说明
    public int myAtoiBetter(String str) {
        int index = 0;
        int sign = 1;
        int result = 0;

        // empty input
        if (str.length() == 0) {
            return 0;
        }

        // jump the space ahead
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        //handle the signal ahead
        if (index < str.length() && str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-'? -1: 1;
            index++;
        }

        // jump the 0 ahead,这个已经被后面的handle了,所以不用写在这
        /*while (index < str.length() && str.charAt(index) == '0') {
            index++;
        }*/

        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {        // invalid digit, we can just return current result now.
                break;
            }

            // check integer overflow
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit) {
                return sign == -1? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
