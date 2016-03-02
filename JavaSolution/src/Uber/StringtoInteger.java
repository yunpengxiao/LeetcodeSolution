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
}
