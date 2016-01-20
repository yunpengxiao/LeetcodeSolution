package FaceBook;

import java.util.Arrays;

/**
 * Created by xyunpeng on 1/19/16.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                result[i + j] += (((num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[i + j + 1]) / 10);
                result[i + j + 1] = (((num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[i + j + 1]) % 10);
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < n + m; i++) {
            if (i == 0 && result[i] == 0) continue;
            res.append(result[i]);
        }
        return res.toString();
    }
}

//看过别人家的代码:  https://leetcode.com/discuss/71593/easiest-java-solution-with-graph-explanation