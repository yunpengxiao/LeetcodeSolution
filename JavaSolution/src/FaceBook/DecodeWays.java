package FaceBook;

/**
 * Created by xyunpeng on 1/22/16.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] decodeNums = new int[s.length() + 1];
        decodeNums[0] = 1;
        decodeNums[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) - '0' > 0 && s.charAt(i - 1) - '0' < 10) {
                decodeNums[i] += decodeNums[i - 1];
            }

            if (Integer.parseInt(s.substring(i - 2, i)) <= 26 && Integer.parseInt(s.substring(i - 2, i)) >= 10) {
                decodeNums[i] += decodeNums[i - 2];
            }
        }
        return decodeNums[s.length()];
    }
}
